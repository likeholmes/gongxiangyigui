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
        GreenUrlSet.add("/user");
        GreenUrlSet.add("/goods");
        GreenUrlSet.add("/index");
        GreenUrlSet.add("/login");
        GreenUrlSet.add("/recom");
        GreenUrlSet.add("/select");
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) srequest;
        String uri = request.getRequestURI();
        if (request.getSession().getAttribute(Const.LOGIN_SESSION_KEY) == null) {
            Cookie[] cookies = request.getCookies();
            if (containsSuffix(uri)  || GreenUrlSet.contains(uri) || containsKey(uri)) {
                logger.debug("don't check  url , " + request.getRequestURI());
                filterChain.doFilter(srequest, sresponse);
                return;
            }else if (cookies!=null) {
                boolean flag = true;
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals(Const.LOGIN_SESSION_KEY)) {
                        if(StringUtils.isNotBlank(cookie.getValue())){
                            flag = false;
                        }else{
                            break;
                        }
                        String adminId = getAdminId(cookie.getValue());
                        Admin admin = adminService.findById(adminId);
                        String html = "";
                        if(null == admin){
                            html = "<script type=\"text/javascript\">window.location.href=\"_BP_login\"</script>";
                        }else{
                            logger.info("userId :" + admin.getId());
                            request.getSession().setAttribute(Const.LOGIN_SESSION_KEY, admin);
                            String referer = this.getRef(request);
                            if(referer.indexOf("/collect?") >= 0 || referer.indexOf("/lookAround") >= 0){
                                filterChain.doFilter(srequest, sresponse);
                                return;
                            }else{
                                html = "<script type=\"text/javascript\">window.location.href=\"_BP_\"</script>";
                            }
                        }
                        html = html.replace("_BP_", Const.BASE_PATH);
                        sresponse.getWriter().write(html);
                        /**
                         * HttpServletResponse response = (HttpServletResponse) sresponse;
                         response.sendRedirect("/");
                         */
                    }
                }

                //跳转到登陆页面
                String referer = this.getRef(request);
                logger.debug("security filter, deney, " + request.getRequestURI());
                String html = "";
                if(referer.contains("/collect?") || referer.contains("/lookAround")){
                    html = "<script type=\"text/javascript\">window.location.href=\"_BP_login\"</script>";
                }else{
                    html = "<script type=\"text/javascript\">window.location.href=\"_BP_index\"</script>";
                }
                    html = html.replace("_BP_", Const.BASE_PATH);
                    sresponse.getWriter().write(html);
                }

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

    /**
     * @param url
     * @return
     * @author neo
     * @date 2016-5-4
     */
    private boolean containsKey(String url) {

        if (url.contains("/media/")
                || url.contains("/login")||url.contains("/user/login")
                || url.contains("/register")||url.contains("/user/regist")||url.contains("/index")
                || url.contains("/forgotPassword")||url.contains("/user/sendForgotPasswordEmail")
                || url.contains("/newPassword")||url.contains("/user/setNewPassword")
                || (url.contains("/collector") && !url.contains("/collect/detail/"))
                || url.contains("/collect/standard/")||url.contains("/collect/simple/")
                || url.contains("/user")||url.contains("/favorites")||url.contains("/comment")
                || url.contains("/lookAround")
                || url.startsWith("/user/")
                || url.startsWith("/feedback")
                || url.startsWith("/standard/")) {
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