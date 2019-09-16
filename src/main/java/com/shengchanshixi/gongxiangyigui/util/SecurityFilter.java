package com.shengchanshixi.gongxiangyigui.util;

import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SecurityFilter implements Filter {

    protected Logger logger =  LoggerFactory.getLogger(this.getClass());
    private static Set<String> GreenUrlSet = new HashSet<String>();

    @Autowired
    private AdminService adminService;

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        GreenUrlSet.add("/user/login");
        GreenUrlSet.add("/user/regist");
        GreenUrlSet.add("/index");
        GreenUrlSet.add("/login");
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) srequest;
        String uri = request.getRequestURI();
        if (request.getSession().getAttribute("login_admin")==null) {
            Cookie[] cookies = request.getCookies();
            if (containsSuffix(uri)  || GreenUrlSet.contains(uri)) {
                logger.debug("don't check  url , " + request.getRequestURI());
                filterChain.doFilter(srequest, sresponse);
                return;
            }else if (cookies!=null) {
                boolean flag = true;
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    String html = "";
                    if (cookie.getName().equals("login_admin")) {
                        if(StringUtils.isNotBlank(cookie.getValue())){
                            flag = false;
                        }else{
                            break;
                        }
                        String adminId = getAdminId(cookie.getValue());
                        Admin admin = adminService.findById(adminId);
                        if(null == admin){
                            html = "<script type=\"text/javascript\">window.location.href=\"_BP_login\"</script>";
                        }else{
                            logger.info("amdinId :" + admin.getId());
                            request.getSession().setAttribute("login_admin", admin);
                            //String referer = this.getRef(request);
                            filterChain.doFilter(srequest, sresponse);
                            return;
                        }
                    }
                    html = html.replace("_BP_", Const.BASE_PATH);
                    sresponse.getWriter().write(html);
                }
                //跳转到登陆页面
                String referer = this.getRef(request);
                logger.debug("security filter, deney, " + request.getRequestURI());
                String html = "";
                html = "<script type=\"text/javascript\">window.location.href=\"_BP_login\"</script>";
                html = html.replace("_BP_", Const.BASE_PATH);
                sresponse.getWriter().write(html);
            }
            //跳转到登陆页面
            String referer = this.getRef(request);
            logger.debug("security filter, deney, " + request.getRequestURI());
            String html = "";
            html = "<script type=\"text/javascript\">window.location.href=\"_BP_login\"</script>";
            html = html.replace("_BP_", Const.BASE_PATH);
            sresponse.getWriter().write(html);
        }else{
            filterChain.doFilter(srequest, sresponse);
        }
    }

    /**
     * @param url
     * @return
     * @author neo
     * @date 2016-5-4
     */
    private boolean containsSuffix(String url) {
        if (url.endsWith(".js")
                || url.endsWith(".css")
                || url.endsWith(".jpg")
                || url.endsWith(".gif")
                || url.endsWith(".png")
                || url.endsWith(".html")
                || url.endsWith(".eot")
                || url.endsWith(".svg")
                || url.endsWith(".ttf")
                || url.endsWith(".woff")
                || url.endsWith(".ico")
                || url.endsWith(".woff2")) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    public  String codeToString(String str) {
        String strString = str;
        try {
            byte tempB[] = strString.getBytes("ISO-8859-1");
            strString = new String(tempB);
            return strString;
        } catch (Exception e) {
            return strString;
        }
    }

    public String getRef(HttpServletRequest request){
        String referer = "";
        String param = this.codeToString(request.getQueryString());
        if(StringUtils.isNotBlank(request.getContextPath())){
            referer = referer + request.getContextPath();
        }
        if(StringUtils.isNotBlank(request.getServletPath())){
            referer = referer + request.getServletPath();
        }
        if(StringUtils.isNotBlank(param)){
            referer = referer + "?" + param;
        }
        request.getSession().setAttribute(Const.LAST_REFERER, referer);
        return referer;
    }

    public String getAdminId(String value){
        try {
            String adminId = Des3EncryptionUtil.decode(Const.DES3_KEY,value);
            adminId = adminId.substring(0,adminId.indexOf(Const.PASSWORD_KEY));
            return adminId;
        }catch (Exception e){
            logger.error("解析cookie异常：",e);
        }
        return null;
    }

}