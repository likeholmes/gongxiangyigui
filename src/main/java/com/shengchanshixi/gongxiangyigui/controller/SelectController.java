package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import com.shengchanshixi.gongxiangyigui.service.BrandService;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.service.TagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Android
 * 筛选控制器
 */
@RequestMapping("/select")
@RestController
public class SelectController extends BaseController {

    @Autowired
    ClothPicService clothPicService;

    @Autowired
    ClothManageService clothManageService;

    @Autowired
    TagService tagService;

    @Autowired
    BrandService brandService;

    @ApiOperation(value = "搜索筛选",notes = "通过搜索栏筛选商品信息")
    @RequestMapping(value = "/search")
    public List<ClothPic> search(@RequestParam("key") String key){
        System.out.println(key);
        return clothPicService.findByList(clothManageService.findBySearch(key));
    }

    //获取全部标签信息
    @ApiOperation(value = "获取所有标签信息",notes = "")
    @RequestMapping(value = "/tags")
    public List<Tag> getTagList(){
        return tagService.findAllList();
    }

    @ApiOperation(value = "获取所有品牌信息",notes = "")
    @RequestMapping(value = "/brands")
    public List<Brand> getBrandList(){
        return brandService.findAllList();
    }

    @ApiOperation(value = "全部筛选",notes = "通过设置条件筛选商品信息")
    @RequestMapping(value = "/term")
    public List<ClothPic> searchBytags(@RequestBody List<Tag> tags){
        return clothPicService.findByList(clothManageService.findByConditon(tags));
    }

    //推荐筛选

}
