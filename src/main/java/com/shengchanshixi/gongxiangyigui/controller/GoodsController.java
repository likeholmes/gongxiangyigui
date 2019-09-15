package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.Order;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.service.OrderManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/rent/{id}")
    public String rent(@PathVariable("id")int id, Order order){
        //TODO:生成订单
        try {
            //只有VIP能租赁衣服
            if (getUser().getLevel()<=0)
                return "0";
            order.setUserid(getUserId());
            order.setClothid(id);
            if(null==orderManageService.add(order))
            {
                logger.warn("未成功生成订单");
                return "0";
            }
            return "1";
        }catch (Exception e){
            logger.error("生成订单出错",e);
            return "0";
        }
    }

    //快递查询信息
}
