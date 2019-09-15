package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.service.BrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web
 * 品牌控制器
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandManageController extends BaseController{
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "删除品牌",notes = "")
    @DeleteMapping(value = "/{id}")
    public String delBrand(@PathVariable("id")int id){
        brandService.delete(id);
        return "redirect:/list";
    }

    @ApiOperation(value = "添加品牌",notes = "")
    @PostMapping(value = "/add")
    public String addBrand(@RequestBody Brand brand){
        brandService.add(brand);
        return "redirect:/list";
    }

    @ApiOperation(value = "显示所有品牌",notes = "")
    @RequestMapping(value = "/list")
    public String getBrands(Model model){
        List<Brand> brands=brandService.findAllList();
        model.addAttribute("brands",brands);
        //TODO:品牌管理首页
        return null;
    }

    @RequestMapping("")
    public String index(){
        return "redirect:/list";
    }
}
