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
@Controller
@RequestMapping(value = "/cloths")
public class ClothManageController extends BaseController{
    @Autowired
    private ClothManageService clothManageService;

    @ApiOperation(value = "删除商品信息",notes = "删除商品信息后显示更新后的所有商品信息")
    @DeleteMapping(value = "/{id}")
    public String delCloth(@PathVariable("id") int id,Model model){
        return null;
    }

    @ApiOperation(value = "获取全部商品信息",notes = "将所有商品信息显示列表")
    @GetMapping(value = "")
    public String getClothList(Model model){
        return null;
    }

    @ApiOperation(value = "添加商品信息",notes = "添加后显示商品总页面")
    @PostMapping(value = "")
    public String addCloth(Model model){
        return null;
    }

    @ApiOperation(value = "去添加商品信息",notes = "跳转至添加信息页面")
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model){
        return null;
    }

    @ApiOperation(value = "去修改商品信息",notes = "跳转至修改信息页面")
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable("id") int id,Model model){
        return null;
    }

    @ApiOperation(value = "修改商品信息",notes = "修改后返回商品页面")
    @PutMapping(value = "/{id}")
    public String editCloth(@PathVariable("id") int id,Model model){
        return null;
    }

    @ApiOperation(value = "获取商品信息",notes = "可以查看商品图片")
    @GetMapping(value = "/{id}")
    public String getCloth(@PathVariable("id") int id,Model model){
        return null;
    }

    @ApiOperation(value = "通过商品名字搜索商品信息",notes = "将所有商品信息列表显示")
    @GetMapping(value = "/list")
    public String getClothByName(@RequestParam("name") String name,Model model){
        return null;
    }

    //还有各种分页显示，搜索，过滤等先省略
    @ApiOperation(value = "排序显示商品信息",notes = "将所有商品信息按某种顺序显示")
    @GetMapping(value = "/list")
    public String getClothSortByKey(@RequestParam("key") String key){ return null; }
}
