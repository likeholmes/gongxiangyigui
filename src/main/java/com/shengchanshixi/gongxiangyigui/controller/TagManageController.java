package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Web
 * 标签控制器
 */
@Controller
@RequestMapping(value = "/tag")
public class TagManageController extends BaseController{
    @ApiOperation(value = "删除标签",notes = "")
    @DeleteMapping(value = "/{tag}")
    public String delTag(@PathVariable("tag") String tag, Model model){
        return null;
    }

    @ApiOperation(value = "新建标签",notes = "")
    @PostMapping(value = "")
    public String addTag(@RequestParam("sort") String sort, Model model){
        return null;
    }

    @ApiOperation(value = "显示所有标签",notes = "")
    @GetMapping(value = "")
    public String getTags(Model model){return null;}
}
