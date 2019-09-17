package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.service.AdminService;
import com.shengchanshixi.gongxiangyigui.service.LogService;
import com.shengchanshixi.gongxiangyigui.util.Const;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private LogService logService;
    /*@ApiOperation(value = "管理员登录",notes = "")
    @PostMapping(value = "/login")
    public String login(Admin admin, HttpServletResponse response){
        try {
            Admin loginAdmin=adminService.findById(admin.getId());
            if (null == loginAdmin)   {
                //TODO:提示框，登陆失败
                //TODO:登陆页面
                logger.warn("没有该管理员");
                return null;
            }else if (!loginAdmin.getId().equals(admin.getPwd())){
                //TODO:提示框，登陆失败
                //TODO:登陆页面
                logger.warn("密码错误");
                return null;
            }
            Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, cookieSign(loginAdmin.getId()));
            cookie.setMaxAge(Const.COOKIE_TIMEOUT);
            cookie.setPath("/");
            response.addCookie(cookie);
            getSession().setAttribute(Const.LOGIN_SESSION_KEY, loginAdmin);
            //TODO:登录成功，跳转至首页
            return null;
        }catch (Exception e) {
            logger.error("Admin login failed, ", e);
            //TODO:出错页面
            return null;
        }
    }*/

    @com.shengchanshixi.gongxiangyigui.util.logUtil.Log(module = "登录管理",description = "管理员登录")
    @ApiOperation(value = "管理员登录",notes = "")
    @PostMapping(value = "/login")
    public String login(Admin admin) {
        try {
            Admin loginAdmin = adminService.findById(admin.getId());
            if (null == loginAdmin) {
                //TODO:提示框，登陆失败
                //TODO:登陆页面
                logger.warn("没有该管理员");
                return "helloHtml";
            } else if (!loginAdmin.getPwd().equals(admin.getPwd())) {
                //TODO:提示框，登陆失败
                //TODO:登陆页面
                logger.warn("密码错误");
                return "helloHtml";
            }
           // Cookie cookie = new Cookie("login_admin", cookieSign(loginAdmin.getId()));
           // cookie.setMaxAge(Const.COOKIE_TIMEOUT);
           // cookie.setPath("/");
            //response.addCookie(cookie);
            getSession().setAttribute("login_admin", loginAdmin);
            //TODO:登录成功，跳转至首页
            return "ManagerMain";
        } catch (Exception e) {
            logger.error("Admin login failed, ", e);
            //TODO:出错页面
            return null;
        }
    }

    @com.shengchanshixi.gongxiangyigui.util.logUtil.Log(module = "登录管理",description = "管理员登出")
    @ApiOperation(value = "管理员登出",notes = "")
    @RequestMapping(value = "/logout")
    public String logout() {
        getSession().invalidate();
        //TODO:登录页面
        return "helloHtml";
    }

    @RequestMapping({"/","/index"})
    public String index(){
        //TODO:登录页面
        return "helloHtml";
    }

    @ApiOperation(value = "查看会员",notes = "")
    @GetMapping(value = "/user/all")
    public String getAllUser(Model model){
        List<User> users=accountService.findAllList();
        model.addAttribute("users",users);
        //TODO:会员管理页面
        return null;
    }

    @ApiOperation(value = "查看所有日志",notes = "")
    @GetMapping(value = "/log")
    public String getAllLog(Model model){
        List<com.shengchanshixi.gongxiangyigui.entity.Log> logs=logService.findAll();
        model.addAttribute("logs",logs);
        //TODO:日志管理页面
        return null;
    }

    @ApiOperation(value = "查看日志详细信息",notes = "")
    @GetMapping(value = "/log/{id}")
    public String getLogDetail(@PathVariable("id")int id, Model model){
        return null;
    }

    @ApiOperation(value = "删除日志",notes = "")
    @DeleteMapping(value = "/log/{id}")
    public String delLog(@PathVariable("id")int id, Model model){
        return null;
    }
}
