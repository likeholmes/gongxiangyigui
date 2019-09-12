package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Collect;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.entity.result.ExceptionMsg;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import com.shengchanshixi.gongxiangyigui.entity.result.ResponseData;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.util.Const;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Android
 * 用户控制器
 */
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

    @Autowired
    private AccountService accountService;

    /*@ApiOperation(value = "用户登录",notes = "")
    @PostMapping(value = "/login")
    public ResponseData login(User user, HttpServletResponse response){
        System.out.println("有用户正在登录");
        try {

            User loginUser=accountService.findById(user.getId());
            if (null == loginUser)   {
                return new ResponseData(ExceptionMsg.LoginNameNotExists);
            }else if (!loginUser.getId().equals(getPwd(user.getPwd()))){
                return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
            }
            Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, cookieSign(loginUser.getId().toString()));
            cookie.setMaxAge(Const.COOKIE_TIMEOUT);
            cookie.setPath("/");
            response.addCookie(cookie);
            getSession().setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
            return new ResponseData(ExceptionMsg.SUCCESS);
        }catch (Exception e) {
            // TODO: handle exception
            logger.error("login failed, ", e);
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }*/
    @PostMapping(value = "/login")
    public String login(@RequestBody User user) {
        System.out.println("有用户正在登录");
        try {

            User loginUser = accountService.findById(user.getId());
            if (null == loginUser) {
                System.out.println("没找到该用户");
                return "0";
            } else if (!loginUser.getPwd().equals(user.getPwd())) {
                return "0";
            }
            return "1";
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("login failed, ", e);
            return "0";
        }
    }

    @ApiOperation(value = "用户注册",notes = "")
    @PostMapping(value = "/regist")
    public Response create(User user) {
        try {
            User registerUser=accountService.findById(user.getId());
            if (null!=registerUser)
            {
                return result(ExceptionMsg.UserNameUsed);
            }
            user.setPwd(getPwd(user.getPwd()));
            user.setRegtime(new java.sql.Timestamp(System.currentTimeMillis()));
            user.setStatus("正常");
            accountService.add(user);
        }catch (Exception e)
        {
            logger.error("create user failed, ", e);
            return result(ExceptionMsg.FAILED);
        }
        return result();
    }

    @ApiOperation(value = "用户个人信息",notes = "")
    @RequestMapping(value = "/info")
    public User getUserInfo()
    {
        return null;
    }

    @ApiOperation(value = "开通会员",notes = "更改会员状态")
    @RequestMapping(value = "/vip")
    public Response vip(int level)
    {
        return null;
    }

    @ApiOperation(value = "收藏",notes = "")
    @RequestMapping(value = "/like/{id}")
    public Response like(@PathVariable("id") int id) {
        return null;
    }

    @ApiOperation(value = "取消收藏",notes = "")
    @RequestMapping(value = "/unlike/{id}")
    public Response delete(@PathVariable("id") int id) {
        return null;
    }

    @ApiOperation(value = "我的收藏",notes = "显示用户所有的收藏")
    @RequestMapping(value = "/collects")
    public List<Collect> getCollectList(){
        return null;
    }

    @ApiOperation(value = "已收藏的商品信息",notes = "显示某个已收藏商品的详细信息")
    @RequestMapping(value = "/collects/{id}")
    public Collect getCollect(@PathVariable("id")int id){
        //转到商品详情页
        return null;
    }

    @ApiOperation(value = "用户订单",notes = "显示用户所有订单")
    @GetMapping(value = "/orders")
    public List<Order> getOrderList(){
        return null;
    }

    //获取订单详情
    @ApiOperation(value = "获取订单信息",notes = "显示选取的商品信息")
    @GetMapping(value = "/orders/{id}")
    public Order getOrder(@PathVariable("id")int id){
        return null;
    }


}
