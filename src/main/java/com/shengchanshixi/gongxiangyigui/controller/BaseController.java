package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.util.Const;
import com.shengchanshixi.gongxiangyigui.util.Des3EncryptionUtil;
import com.shengchanshixi.gongxiangyigui.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    protected Logger logger =  LoggerFactory.getLogger(this.getClass());

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    protected Admin getAdmin() {
        return (Admin) getSession().getAttribute("login_admin");
    }

    protected User getUser() {
        return (User) getSession().getAttribute("login_user");
    }

    protected String getUserId() {
        String userid="share_member";
        User user=getUser();
        if(user!=null)
            userid=user.getId();
        return userid;
    }

    protected String getUserIp() {
        String value = getRequest().getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(value) && !"unknown".equalsIgnoreCase(value)) {
            return value;
        } else {
            return getRequest().getRemoteAddr();
        }
    }

    protected String getPwd(String password){
        try {
            String pwd = MD5Util.encrypt(password+Const.PASSWORD_KEY);
            return pwd;
        } catch (Exception e) {
            logger.error("密码加密异常：",e);
        }
        return null;
    }

    protected String cookieSign(String value){
        try{
            value = value + Const.PASSWORD_KEY;
            String sign = Des3EncryptionUtil.encode(Const.DES3_KEY,value);
            return sign;
        }catch (Exception e){
            logger.error("cookie签名异常：",e);
        }
        return null;
    }
}