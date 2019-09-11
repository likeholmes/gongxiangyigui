package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ApiOperation(value = "搜索筛选",notes = "通过搜索栏筛选商品信息")
    @RequestMapping(value = "/key")
    List<Cloth> search(String key){
        return null;
    }

    //获取全部标签信息
    @ApiOperation(value = "获取所有标签信息",notes = "")
    @RequestMapping(value = "/tags")
    List<Tag> getTagList(){
        return null;
    }

    @ApiOperation(value = "全部筛选",notes = "通过设置条件筛选商品信息")
    @RequestMapping(value = "/term")
    List<Cloth> searchBytags(HttpServletRequest request){
        return null;
    }

    //推荐筛选

}
