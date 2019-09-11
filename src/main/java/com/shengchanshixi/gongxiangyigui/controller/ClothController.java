package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web
 * 服装控制器
 */
@RestController
@RequestMapping(value = "/cloths")
public class ClothController extends BaseController{
    @Autowired
    private ClothManageService clothManageService;

    @ApiOperation(value = "删除商品信息",notes = "删除商品信息后显示更新后的所有商品信息")
    @RequestMapping(value = "/delete/{id}")
    public Response delCloth(@PathVariable("id") int id){
        return null;
    }

    @ApiOperation(value = "获取全部商品信息",notes = "将所有商品信息显示列表")
    @RequestMapping(value = "")
    public List<Cloth> getClothList(){
        return null;
    }

    //是否还需要写去添加，跳转到表单页面
    @ApiOperation(value = "添加商品信息",notes = "暂时还没确定传入的是什么信息")
    @PostMapping(value = "/cloth")
    public Response addCloth(Cloth cloth){
        return null;
    }

    //是否需要些去修改，跳转到表单页面
    @ApiOperation(value = "修改商品信息",notes = "暂时还没确定传入的是什么信息")
    @PutMapping(value = "/{id}")
    public Response editCloth(@PathVariable("id") int id,@RequestBody Cloth ncloth){
        return null;
    }

    @ApiOperation(value = "获取商品信息",notes = "可以查看商品图片")
    @GetMapping(value = "/{id}")
    public Cloth getCloth(@PathVariable("id") int id){
        return null;
    }

    @ApiOperation(value = "通过商品名字搜索商品信息",notes = "将所有商品信息列表显示")
    @GetMapping(value = "/search/{name}")
    public List<Cloth> getClothByName(@PathVariable("name") String name){
        return null;
    }

    //还有各种分页显示，搜索，过滤等先省略
}
