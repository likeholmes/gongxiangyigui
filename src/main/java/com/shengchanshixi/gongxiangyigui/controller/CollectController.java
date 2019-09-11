package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Collect;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Android
 * 收藏控制器
 */
@RestController
@RequestMapping("/collect")
public class CollectController extends BaseController{

    @ApiOperation(value = "收藏",notes = "")
    @RequestMapping(value = "/like/{id}")
    public Response like(@PathVariable("id") int id) {
        return null;
    }

    @ApiOperation(value = "取消收藏",notes = "")
    @RequestMapping(value = "/delete/{id}")
    public Response delete(@PathVariable("id") int id) {
        return null;
    }

    @ApiOperation(value = "收藏列表",notes = "显示用户所有的收藏")
    @RequestMapping(value = "/list")
    public List<Collect> getCollectList(){
        return null;
    }

    @ApiOperation(value = "已收藏的商品信息",notes = "显示某个已收藏商品的详细信息")
    @RequestMapping(value = "/{id}")
    public Collect getCollect(@PathVariable("id")int id){
        //转到商品详情页
        return null;
    }
}
