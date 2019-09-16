package com.shengchanshixi.gongxiangyigui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shengchanshixi.gongxiangyigui.dao.LogDao;
import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.Log;
import com.shengchanshixi.gongxiangyigui.service.LogService;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    private String username;

    @Autowired
    private LogDao logDao;

    public String initUsername(String username) {
        if(!StringUtils.isEmpty(username)){
            this.username = username;
        }
        return this.username;
    }


    public void put(JoinPoint joinPoint, String methodName, String module, String description) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Log log = new Log();
            //获取Admin
            Admin admin=(Admin)request.getSession().getAttribute("login_admin");
            String ip = request.getHeader("X-Real-IP");
            if (null==ip)
                ip=request.getRemoteAddr();
            log.setAdminid(admin.getId());
            log.setModule(module);
            log.setIp(ip);
            log.setOperate(description);
            log.setDetail(operateContent(joinPoint, methodName, ip));
            log.setTime(new java.sql.Timestamp(System.currentTimeMillis()));
            //insert(log);
            logDao.save(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有日志
     * @param
     * @param
     * @return
     */
    public List<Log> findAll() {
        return logDao.findAll();
    }


    public String operateContent(JoinPoint joinPoint, String methodName, String ip) throws ClassNotFoundException, NotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        Map<String,Object > nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName,params);
        StringBuffer bf = new StringBuffer();
        if (!CollectionUtils.isEmpty(nameAndArgs)){
            Iterator it = nameAndArgs.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                String value = JSONObject.toJSONString(entry.getValue());
                bf.append(key).append("=");
                bf.append(value).append("&");
            }
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), ip);
    }

    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String,Object > map=new HashMap<String,Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
            return map;
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++){
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名
        }
        return map;
    }
}
