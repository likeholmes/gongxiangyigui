package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.*;
import com.shengchanshixi.gongxiangyigui.entity.result.Response;
import com.shengchanshixi.gongxiangyigui.service.BrandService;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import com.shengchanshixi.gongxiangyigui.service.ClothPicService;
import com.shengchanshixi.gongxiangyigui.service.TagService;
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

/**
 * Web
 * 服装控制器
 */
@Controller
@RequestMapping(value = "/cloths")
public class ClothManageController extends BaseController{
    @Autowired
    private ClothManageService clothManageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ClothPicService clothPicService;

    @RequestMapping("")
    public String index(){
        return "redirect:/list";
    }

    @ApiOperation(value = "删除商品信息",notes = "删除商品信息后显示更新后的所有商品信息")
    @DeleteMapping(value = "/{id}")
    public String delCloth(@PathVariable("id") int id){
        clothManageService.delete(id);
        return "redirect:/list";
    }

    @ApiOperation(value = "获取全部商品信息",notes = "将所有商品信息显示列表")
    @RequestMapping(value = "/list")
    public String getClothList(Model model){
        List<Cloth> cloths=clothManageService.findAll();
        model.addAttribute("cloths",cloths);
        //TODO:商品管理首页
        return null;
    }

    @ApiOperation(value = "添加商品信息",notes = "添加后显示商品总页面")
    @PostMapping(value = "/add")
    public String addCloth(Cloth cloth,List<ClothPic> clothPics){
        if(null==clothManageService.add(cloth))
            logger.warn("添加信息未成功");
        else {
            //添加图片
            Cloth ncloth = clothManageService.findAfterTime(System.currentTimeMillis());
            if (null == ncloth) {
                logger.warn("添加信息未成功");
            } else {
                //TODO:图片未上传
                for (ClothPic clothPic : clothPics
                        ) {
                    clothPic.setClothId(ncloth.getId());
                }
            }

        }
        return "redirect:/list";
    }

    @ApiOperation(value = "去添加商品信息",notes = "跳转至添加信息页面")
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model){
        List<Tag> sizes=tagService.findBySort("尺寸");
        model.addAttribute("sizes",sizes);
        List<Tag> styles=tagService.findBySort("风格");
        model.addAttribute("styles",styles);
        List<Tag> scenes=tagService.findBySort("场景");
        model.addAttribute("scenes",scenes);
        List<Tag> colors=tagService.findBySort("颜色");
        model.addAttribute("colors",colors);
        List<Tag> parts=tagService.findBySort("部位");
        model.addAttribute("parts",parts);
        List<Tag> seasons=tagService.findBySort("季节");
        model.addAttribute("seasons",seasons);
        List<Brand> brands=brandService.findAllList();
        model.addAttribute("brands",brands);
        //TODO:添加页面
        return null;
    }

    @ApiOperation(value = "去修改商品信息",notes = "跳转至修改信息页面")
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable("id") int id,Model model){
        Cloth cloth=clothManageService.findById(id);
        model.addAttribute("cloth",cloth);
        List<ClothPic> clothPics=clothPicService.findByClothid(id);
        model.addAttribute("clothPics",clothPics);
        List<Tag> sizes=tagService.findBySort("尺寸");
        model.addAttribute("sizes",sizes);
        List<Tag> styles=tagService.findBySort("风格");
        model.addAttribute("styles",styles);
        List<Tag> scenes=tagService.findBySort("场景");
        model.addAttribute("scenes",scenes);
        List<Tag> colors=tagService.findBySort("颜色");
        model.addAttribute("colors",colors);
        List<Tag> parts=tagService.findBySort("部位");
        model.addAttribute("parts",parts);
        List<Tag> seasons=tagService.findBySort("季节");
        model.addAttribute("seasons",seasons);
        List<Brand> brands=brandService.findAllList();
        model.addAttribute("brands",brands);
        //TODO:去编辑页面
        return null;
    }

    @ApiOperation(value = "修改商品信息",notes = "修改后返回商品页面")
    @PutMapping(value = "/{id}")
    public String editCloth(@PathVariable("id")int id,Cloth cloth,List<ClothPic> clothPics){
        cloth.setId(id);
        clothManageService.update(cloth);
        //TODO:修改图片？？
        return "redirect:/list";
    }

    @ApiOperation(value = "获取商品信息",notes = "可以查看商品图片")
    @GetMapping(value = "/{id}")
    public String getCloth(@PathVariable("id") int id,Model model){
        Cloth cloth=clothManageService.findById(id);
        model.addAttribute("cloth",cloth);
        //TODO:服装详细信息页
        return null;
    }

    @ApiOperation(value = "通过商品名字搜索商品信息",notes = "将所有商品信息列表显示")
    @GetMapping(value = "/search")
    public String getClothByName(@RequestParam("name") String name,Model model){
        List<Cloth> cloths=clothManageService.findByName(name);
        model.addAttribute("cloths",cloths);
        //TODO:搜索后的服装列表页
        return null;
    }

    //还有各种分页显示，搜索，过滤等先省略
    @ApiOperation(value = "排序显示商品信息",notes = "将所有商品信息按某种顺序显示")
    @GetMapping(value = "/sort")
    public String getClothSortByKey(@RequestParam("key") String key,Model model){
        List<Cloth> cloths=clothManageService.findAll();
        model.addAttribute("cloths",cloths);
        //TODO:未完成
        return null;
    }
}
