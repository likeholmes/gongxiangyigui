package com.shengchanshixi.gongxiangyigui.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {
    @ApiOperation(value = "冻结账户",notes = "")
    @RequestMapping(value = "/lock/{id}")
    public String lock(@PathVariable("id")String id,Model model){
        return null;
    }

    @ApiOperation(value = "解冻账户",notes = "")
    @RequestMapping(value = "/unlock/{id}")
    public String unlock(@PathVariable("id")String id,Model model){
        return null;
    }

    @ApiOperation(value = "显示所有账户",notes = "")
    @GetMapping(value = "")
    public String getAccounts(Model model){return null;}
}
