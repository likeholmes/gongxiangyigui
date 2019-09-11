package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/api/cloth")
public class ClothManageController {
    @Autowired
    private ClothManageService clothManageService;

    /*@ApiOperation(value = "获取服装列表",notes = "")
    @GetMapping(value = "/list")
    public String getCloth(Model model){
        //int page=1,size=10;
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(page, size, sort);
        List<Cloth> cloths=clothManageService.findAllList();
        model.addAttribute("cloths",cloths);
        return "cloth/list";
    }*/

    @ApiOperation(value = "获取服装分页",notes = "")
    @GetMapping(value = "/list")
    public String getClothBySearch(Model model){
        int page=1,size=3;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Cloth> cloths=clothManageService.findAllPage(pageable);
        model.addAttribute("cloths",cloths);
        return "cloth/list";
    }

    @ApiOperation(value = "跳转dao添加页面",notes = "")
    @RequestMapping(value = "/toAdd")
    public String toAdd()
    {
        return "cloth/add";
    }

}
