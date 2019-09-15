package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.ClothPic;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Android
 * 推荐控制器
 */
@RestController
@RequestMapping(value = "/recom")
public class RecommendController extends BaseController{
    @Autowired
    private ClothManageService clothManageService;

    @Autowired
    private ClothPicService clothPicService;

    @ApiOperation(value = "上新推荐",notes = "从新dao旧显示20个服装信息")
    @RequestMapping(value = "/new")
    //如何分页显示，应该传入什么API和参数
    public List<ClothPic> recomNew(){
        return clothPicService.findByList(clothManageService.findByTime());
    }

    @ApiOperation(value = "随机推荐",notes = "随机显示20个服装信息")
    @RequestMapping(value = "/random")
    public List<ClothPic> recomRandom(){
        return clothPicService.findByList(clothManageService.findByRandom());
    }

    //TODO:待写
    @ApiOperation(value = "品牌推荐",notes = "显示10个不同品牌销量最高的商品")
    @RequestMapping(value = "/brand")
    public List<Cloth> recomBrand(){
        return null;
    }

    @ApiOperation(value = "个性推荐",notes = "显示10个根据用户收藏的商品")
    @RequestMapping(value = "/special")
    public List<ClothPic> recomSpecial(){
        return clothPicService.findByList(clothManageService.findBySpecial());
    }

}
