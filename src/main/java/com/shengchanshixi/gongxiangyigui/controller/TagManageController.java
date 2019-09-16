package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Tag;
import com.shengchanshixi.gongxiangyigui.service.TagService;
import com.shengchanshixi.gongxiangyigui.util.logUtil.Log;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web
 * 标签控制器
 */
@Controller
@RequestMapping(value = "/tag")
public class TagManageController extends BaseController{

    @Autowired
    private TagService tagService;

    @Log(module = "标签管理",description = "删除标签")
    @ApiOperation(value = "删除标签",notes = "")
    @DeleteMapping(value = "/{tag}")
    public String delTag(@PathVariable("tag") String tag){
        tagService.delete(tag);
        return "redirect:/list";
    }

    @Log(module = "标签管理",description = "删除标签")
    @ApiOperation(value = "新建标签",notes = "")
    @PostMapping(value = "/add")
    public String addTag(@RequestParam("sort") String sort,@RequestParam("tag") String tag){
        Tag ntag=new Tag();
        ntag.setSort(sort);
        ntag.setTag(tag);
        tagService.add(ntag);
        return "redirect:/list";
    }

    @ApiOperation(value = "显示所有标签",notes = "")
    @GetMapping(value = "/list")
    public String getTags(Model model){
        List<Tag> tags=tagService.findAllList();
        model.addAttribute("tags",tags);
        //TODO:标签管理首页
        return null;
    }

    @RequestMapping("")
    public String index(){
        return "redirect:/list";
    }
}
