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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cloths")
public class ClothManageController {
    @Autowired
    private ClothManageService clothManageService;

    @ApiOperation(value = "获取全部商品信息",notes = "将所有商品信息分页显示")
    @GetMapping(value = "")
    public List<Cloth> getClothPage(){
        //int page=1,size=3;
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(page, size, sort);
        //Page<Cloth> cloths=clothManageService.findAllPage(pageable);
        //return cloths;
        return clothManageService.findAllList();
    }

    @ApiOperation(value = "添加商品信息",notes = "暂时还没确定传入的是什么信息")
    @PostMapping(value = "/cloth")
    public List<Cloth> addCloth(@RequestBody Cloth cloth){
        clothManageService.add(cloth);
        return clothManageService.findAllList();
    }

    @ApiOperation(value = "修改商品信息",notes = "暂时还没确定传入的是什么信息")
    @PutMapping(value = "/{id}")
    public Cloth addCloth(@PathVariable int id,@RequestBody Cloth ncloth){
        return clothManageService.update(ncloth);
    }

    @ApiOperation(value = "获取商品信息",notes = "可以查看商品图片")
    @GetMapping(value = "/{id}")
    public Cloth addCloth(@PathVariable int id){
        return clothManageService.findById(id);
    }


}
