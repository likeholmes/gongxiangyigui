package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.service.AccountService;
import com.shengchanshixi.gongxiangyigui.util.logUtil.Log;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;


    @Log(module = "会员管理",description = "冻结用户")
    @ApiOperation(value = "冻结账户", notes = "")
    @RequestMapping(value = "/lock/{id}")
    public String lock(@PathVariable("id") String id) {
        try {
            User user = accountService.lockAccount(id);
            if (null == user) {
                logger.warn("未成功冻结用户");
            }
        } catch (Exception e) {
            logger.error("冻结用户出错",e);
            return null;
        }
        System.out.println("lockuser");
        return "redirect:/list";
    }

    @Log(module = "会员管理",description = "解锁用户")
    @ApiOperation(value = "解冻账户", notes = "")
    @RequestMapping(value = "/unlock/{id}")
    public String unlock(@PathVariable("id") String id) {
        try {
            User user = accountService.unlockAccount(id);
            if (null == user) {
                logger.warn("未成功解锁用户");
            }
        } catch (Exception e) {
            logger.error("解锁用户出错",e);
            return null;
        }
        System.out.println("unlockuser");
        return "redirect:/list";
    }

    @ApiOperation(value = "显示所有账户", notes = "")
    @RequestMapping(value = "/list")
    public String getAccounts(Model model) {
        List<User> users=accountService.findAllList();
        model.addAttribute("users",users);
        //用户首页
        logger.info("将users渲染");
        return "account/list";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/list";
    }
}
