package com.shengchanshixi.gongxiangyigui.controller;

import com.alibaba.fastjson.JSON;
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
    @RequestMapping(value = "/del")
    public String delTag(@RequestParam("tag") String tag){
        tagService.delete(tag);
        return "redirect:/tag/list";
    }

    @Log(module = "标签管理",description = "删除标签")
    @ApiOperation(value = "新建标签",notes = "")
    @PostMapping(value = "/add")
    public String addTag(@RequestParam("sort") String sort,@RequestParam("tag") String tag){
        Tag ntag=new Tag();
        ntag.setSort(sort);
        ntag.setTag(tag);
        tagService.add(ntag);
        return "redirect:/tag/list";
    }

    @ApiOperation(value = "显示所有标签",notes = "")
    @GetMapping(value = "/list")
    public String getTags(Model model){
        List<Tag> sizes=tagService.findBySort("尺寸");
        System.out.println(JSON.toJSONString(sizes));
        model.addAttribute("sizes",sizes);
        List<Tag> colors=tagService.findBySort("颜色");
        model.addAttribute("colors",colors);
        List<Tag> styles=tagService.findBySort("风格");
        model.addAttribute("styles",styles);
        List<Tag> scenes=tagService.findBySort("场景");
        model.addAttribute("scenes",scenes);
        List<Tag> parts=tagService.findBySort("部位");
        model.addAttribute("parts",parts);
        List<Tag> seasons=tagService.findBySort("季节");
        model.addAttribute("seasons",seasons);
        //TODO:标签管理首页
        return "Tag";
    }

    @RequestMapping({"","/index"})
    public String index(){
        return "redirect:/tag/list";
    }
}
