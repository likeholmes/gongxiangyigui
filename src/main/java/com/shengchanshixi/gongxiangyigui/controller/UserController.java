package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import com.shengchanshixi.gongxiangyigui.entity.result.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Android
 * 用户控制器
 */
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

    @ApiOperation(value = "用户登录",notes = "")
    @PostMapping(value = "/login")
    public ResponseData login(User user, HttpServletResponse response){
        return null;
    }

    @ApiOperation(value = "用户注册",notes = "")
    @PostMapping(value = "/regist")
    public Response create(User user) {
        return null;
    }

    @ApiOperation(value = "用户个人信息",notes = "")
    @RequestMapping(value = "/info")
    public User getUserInfo()
    {
        return null;
    }
}
