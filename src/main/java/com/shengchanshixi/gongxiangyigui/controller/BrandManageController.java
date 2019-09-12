package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Web
 * 品牌控制器
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandManageController extends BaseController{
    @ApiOperation(value = "删除品牌",notes = "")
    @DeleteMapping(value = "/{id}")
    public String delBrand(@PathVariable("id")int id,Model model){
        return null;
    }

    @ApiOperation(value = "添加品牌",notes = "")
    @PostMapping(value = "")
    public String addBrand(Model model){
        return null;
    }

    @ApiOperation(value = "显示所有品牌",notes = "")
    @GetMapping(value = "")
    public String getBrands(Model model){return null;}
}
