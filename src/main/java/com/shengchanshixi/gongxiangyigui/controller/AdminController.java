package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sys")
public class AdminController extends BaseController {
    @ApiOperation(value = "管理员登录",notes = "")
    @PostMapping(value = "/login")
    public String login(){
        return null;
    }

    @ApiOperation(value = "查看所有日志",notes = "")
    @GetMapping(value = "/log")
    public String getAllLog(Model model){
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
