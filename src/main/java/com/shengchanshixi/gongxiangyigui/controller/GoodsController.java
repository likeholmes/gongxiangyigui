package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Android
 * 商品控制器
 */
@RestController
public class GoodsController extends BaseController{

    //支付页

    //获取商品详情
    @ApiOperation(value = "获取商品信息",notes = "显示选取的商品信息")
    @GetMapping(value = "/goods/{id}")
    public Cloth getCloth(@PathVariable("id")int id){
        return null;
    }

    //评论页

    //租赁页--->传递服装的信息和快递公司信息
    @ApiOperation(value = "租赁商品",notes = "")
    @RequestMapping(value = "/rent/{id}")
    public Response rent(@PathVariable("id")int id){
        return null;
    }

    //快递查询信息
}
