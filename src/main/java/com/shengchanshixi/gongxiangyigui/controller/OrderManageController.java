package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/order")
public class OrderManageController extends BaseController{
    @ApiOperation(value = "显示全部订单",notes = "")
    @GetMapping(value = "/all")
    public String getAll(Model model){
        return null;
    }

    @ApiOperation(value = "删除订单",notes = "")
    @DeleteMapping(value = "/{id}")
    public String delOrder(@PathVariable("id")String id, Model model){
        return null;
    }

    @ApiOperation(value = "显示订单详细信息",notes = "")
    @GetMapping(value = "/{id}")
    public String getOrder(@PathVariable("id")String id, Model model){
        return null;
    }
}
