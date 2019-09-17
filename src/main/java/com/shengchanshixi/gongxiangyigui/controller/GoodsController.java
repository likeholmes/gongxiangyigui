package com.shengchanshixi.gongxiangyigui.controller;

import com.alibaba.fastjson.JSON;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.service.OrderManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * Android
 * 商品控制器
 */
@RestController
public class GoodsController extends BaseController{
    @Autowired
    private ClothManageService clothManageService;

    @Autowired
    private ClothPicService clothPicService;

    @Autowired
    private OrderManageService orderManageService;
    //支付页

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "获取所有商品图片",notes = "显示所有的商品图片")
    @GetMapping(value = "/goods/all")
    public List<ClothPic> getClothPics(){
        return clothPicService.findAll();
    }

    //获取商品详情
    @ApiOperation(value = "获取商品信息",notes = "显示选取的商品信息")
    @GetMapping(value = "/goods/{id}")
    public Cloth getCloth(@PathVariable("id")int id){
        return clothManageService.findById(id);
    }

    //获取商品图片
    @ApiOperation(value = "获取商品图片",notes = "显示选取的商品图片")
    @GetMapping(value = "/goods/{id}/pic")
    public List<ClothPic> getClothPic(@PathVariable("id")int id){
        return clothPicService.findByClothid(id);
    }

    //评论页

    //租赁页--->传递服装的信息和快递公司信息
    //TODO:还没有确定返回值类型
    @ApiOperation(value = "租赁商品",notes = "")
    @RequestMapping(value = "/rent")
    public String rent(@RequestParam("clothid") int clothid,@RequestParam("userid") String userid){
        //TODO:生成订单
        System.out.println("test");
        try {
            //只有VIP能租赁衣服
            System.out.println("租赁服装");
            Order order=new Order();
            User user=accountService.findById(userid);
            order.setUserid(userid);
            order.setClothid(clothid);
            order.setPhone(user.getPhone());
            order.setBugdeal("未处理");
            order.setBacktime(7);
            if (null==user.getAddress())
                return "-1";
            order.setAddress(user.getAddress());
            if (user.getLevel()<=0)
                return "-2";
            System.out.println(JSON.toJSONString(order));
            if(null==orderManageService.add(order))
            {
                logger.warn("未成功生成订单");
                return "-3";
            }
            return "1";
        }catch (Exception e){
            logger.error("生成订单出错",e);
            return "0";
        }
    }

    //快递查询信息
}
