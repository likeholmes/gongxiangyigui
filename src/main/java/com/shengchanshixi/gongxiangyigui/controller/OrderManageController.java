package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "处理异常订单",notes = "")
    @PutMapping(value = "/{id}")
    public String dealOrder(@PathVariable("id")String id, Model model){
        return null;
    }

    @ApiOperation(value = "显示等待发货的订单",notes = "")
    @GetMapping(value = "/send/all")
    public String getAllSend(Model model){
        return null;
    }

    @ApiOperation(value = "填写物流信息",notes = "")
    @PutMapping(value = "/send/{id}")
    public String setSend(@PathVariable("id")String id, Model model){
        return null;
    }

    @ApiOperation(value = "显示等待返还的订单",notes = "已逾期的订单不在其中")
    @GetMapping(value = "/back/all")
    public String getAllBack(Model model){
        return null;
    }

    @ApiOperation(value = "确认已取件",notes = "")
    @PutMapping(value = "/back/{id}")
    public String confirmOk(@PathVariable("id")String id, Model model){
        return null;
    }

    @ApiOperation(value = "搜索订单信息",notes = "")
    @GetMapping(value = "")
    public String searchAll(@RequestParam("key")String key,Model model){
        return null;
    }

    @ApiOperation(value = "搜索等待发货订单信息",notes = "")
    @GetMapping(value = "/send")
    public String searchSend(@RequestParam("key")String key,Model model){
        return null;
    }

    @ApiOperation(value = "搜索等待取回订单信息",notes = "")
    @GetMapping(value = "/back")
    public String searchBack(@RequestParam("key")String key,Model model){
        return null;
    }

    @ApiOperation(value = "显示等待审核的订单",notes = "")
    @GetMapping(value = "/check/all")
    public String getAllCheck(Model model){
        return null;
    }

    @ApiOperation(value = "处理等待审核的订单",notes = "")
    @GetMapping(value = "/check/{id}")
    public String checkOrder(@PathVariable("id")String id,Model model){
        return null;
    }

    @ApiOperation(value = "搜索等待取回订单信息",notes = "")
    @GetMapping(value = "/check")
    public String searchCheck(@RequestParam("key")String key,Model model){
        return null;
    }

}
