package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.service.OrderManageService;
import com.shengchanshixi.gongxiangyigui.util.logUtil.Log;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderManageController extends BaseController{

    @Autowired
    OrderManageService orderManageService;

    @Autowired
    ClothPicService clothPicService;

    @RequestMapping("")
    public String index(){
        return "redirect:/all";
    }

    @ApiOperation(value = "显示全部订单",notes = "")
    @GetMapping(value = "/all")
    public String getAll(Model model){
        List<Order> orders=orderManageService.findAll();
        model.addAttribute("orders",orders);
        //TODO:订单管理首页
        return null;
    }

    @Log(module = "订单管理",description = "删除订单")
    @ApiOperation(value = "删除订单",notes = "")
    @DeleteMapping(value = "/{id}")
    public String delOrder(@PathVariable("id")String id){
        return null;
    }

    @ApiOperation(value = "显示订单详细信息",notes = "")
    @GetMapping(value = "/{id}")
    public String getOrder(@PathVariable("id")String id, Model model){
        Order order=orderManageService.findById(id);
        model.addAttribute("order",order);
        List<ClothPic> clothPics=clothPicService.findByClothid(order.getClothid());
        model.addAttribute("clothPics",clothPics);
        //TODO:订单详情页
        return null;
    }

    @Log(module = "订单管理",description = "处理异常订单")
    @ApiOperation(value = "处理异常订单",notes = "")
    @PutMapping(value = "/{id}")
    public String dealOrder(@PathVariable("id")String id){
        orderManageService.dealBugOrder(id);
        return "redirect:/check/all";
    }

    @ApiOperation(value = "显示等待发货的订单",notes = "")
    @GetMapping(value = "/send/all")
    public String getAllSend(Model model){
        List<Order> orders=orderManageService.findForSendOrder();
        model.addAttribute("orders",orders);
        //TODO:待发货订单首页
        return null;
    }

    @Log(module = "订单管理",description = "处理待发货订单")
    @ApiOperation(value = "填写物流信息",notes = "")
    @PutMapping(value = "/send/{id}")
    public String setSend(@PathVariable("id")String id,@RequestParam("trackid") String trackid){
        System.out.println(trackid);
        orderManageService.dealSendOrder(id,trackid);
        return "redirect:/send/all";
    }

    @ApiOperation(value = "显示等待返还的订单",notes = "已逾期的订单不在其中")
    @GetMapping(value = "/back/all")
    public String getAllBack(Model model){
        List<Order> orders=orderManageService.findForBackOrder();
        model.addAttribute("orders",orders);
        //TODO:待归还首页
        return null;
    }

    @Log(module = "订单管理",description = "处理待取件订单")
    @ApiOperation(value = "确认已取件",notes = "")
    @PutMapping(value = "/back/{id}")
    public String confirmOk(@PathVariable("id")String id){
        orderManageService.dealBackOrder(id);
        return "redirect:/back/all";
    }

    @ApiOperation(value = "搜索订单信息",notes = "")
    @GetMapping(value = "/search")
    public String searchAll(@RequestParam("key")String key,Model model){
        List<Order> orders=orderManageService.searchByKey(key,orderManageService.findAll());
        model.addAttribute("orders",orders);
        //TODO:搜索后的订单管理页面
        return null;
    }

    @ApiOperation(value = "搜索等待发货订单信息",notes = "")
    @GetMapping(value = "/send")
    public String searchSend(@RequestParam("key")String key,Model model){
        List<Order> orders=orderManageService.searchByKey(key,orderManageService.findForSendOrder());
        model.addAttribute("orders",orders);
        //TODO:搜索后的待发货订单管理页面
        return null;
    }

    @ApiOperation(value = "搜索等待取回订单信息",notes = "")
    @GetMapping(value = "/back")
    public String searchBack(@RequestParam("key")String key,Model model){
        List<Order> orders=orderManageService.searchByKey(key,orderManageService.findForBackOrder());
        model.addAttribute("orders",orders);
        //TODO:搜索后的待取回订单管理页面
        return null;
    }

    @ApiOperation(value = "显示等待审核的订单",notes = "")
    @GetMapping(value = "/check/all")
    public String getAllCheck(Model model){
        List<Order> orders=orderManageService.findForCheckOrder();
        model.addAttribute("orders",orders);
        //TODO:搜索后的订单管理页面
        return null;
    }

    @Log(module = "订单管理",description = "处理待审核订单")
    @ApiOperation(value = "等待审核的订单",notes = "")
    @GetMapping(value = "/check/{id}")
    public String checkOrder(@PathVariable("id")String id,@RequestParam("deal")String deal){
        switch (deal){
            case "通过":
                orderManageService.checkClothOk(id);
                //TODO:弹出返还押金对话框
                break;
            case "损坏":
                orderManageService.checkClothBad(id);
                break;
            case "丢失":
                orderManageService.checkClothGone(id);
                break;
        }
        return "redirect:/check/all";
    }

    @ApiOperation(value = "搜索等待审核订单信息",notes = "")
    @GetMapping(value = "/check")
    public String searchCheck(@RequestParam("key")String key,Model model){
        List<Order> orders=orderManageService.searchByKey(key,orderManageService.findForCheckOrder());
        model.addAttribute("orders",orders);
        //TODO:搜索后的待审核订单管理页面
        return null;
    }

}
