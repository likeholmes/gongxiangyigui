package com.shengchanshixi.gongxiangyigui.controller;

import com.shengchanshixi.gongxiangyigui.entity.Feedback;
import com.shengchanshixi.gongxiangyigui.entity.Msg;
import com.shengchanshixi.gongxiangyigui.service.FeedbackService;
import com.shengchanshixi.gongxiangyigui.util.logUtil.Log;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web
 * 反馈控制器
 */
@Controller
@RequestMapping("feedback")
public class FeedbackController extends BaseController{

    @Autowired
    private FeedbackService feedbackService;

    //注入SimpMessagingTemplate 用于点对点消息发送
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("")
    public String index(){
        return "redirect:/list";
    }

    @ApiOperation(value = "所有反馈", notes = "")
    @GetMapping(value = "/list")
    public String findFeedBackList(Model model){
        List<Feedback> feedbacks=feedbackService.findAllList();
        model.addAttribute("feedbacks",feedbacks);
        //TODO:反馈管理首页
        return null;
    }

    @ApiOperation(value = "查看反馈详细信息", notes = "")
    @GetMapping(value = "/{id}")
    public String chat(@PathVariable("id")int id, Model model){
        Feedback feedback=feedbackService.findById(id);
        model.addAttribute("feedback",feedback);
        return null;
    }

    @Log(module = "反馈管理",description = "删除反馈")
    @ApiOperation(value = "删除反馈", notes = "")
    @DeleteMapping(value = "/{id}")
    public String delFeedBack(@PathVariable("id")int id){
        feedbackService.delete(id);
        return "redirect:/list";
    }

    @ApiOperation(value = "按关键词搜索反馈", notes = "")
    @GetMapping(value = "/search")
    public String findBykey(@RequestParam("key") String key,Model model){
        List<Feedback> feedbacks=feedbackService.findByKey(key);
        model.addAttribute("feedbacks",feedbacks);
        return null;
    }

    @ApiOperation(value = "查看与用户的反馈通讯信息", notes = "")
    @GetMapping(value = "/{id}/msg")
    public String findFeedBackMsgs(@PathVariable("id")int id,Model model){
        List<Msg> msgs=feedbackService.findMsgs(id);
        model.addAttribute("msgs",msgs);
        //TODO:通信画面
        return null;
    }

    @ApiOperation(value = "回复消息", notes = "管理员发送消息")
    @MessageMapping(value = "/{id}/msg/reply")
    public String adminReply(@PathVariable("id")int id,@RequestBody Msg msg){
        String userid=feedbackService.findById(id).getUserid();
        msg.setFeedbackid(id);
        msg.setUserid("admin");
        messagingTemplate.convertAndSendToUser(userid,"/queue/notifications",msg.getMessage());
        return null;
    }

    //Android发送
    @ApiOperation(value = "发布反馈", notes = "用户提交反馈")
    @PostMapping(value = "/add")
    public String addFeedBack(@RequestBody Feedback feedback){
        try {
            feedback.setUserid(getUserId());
            feedbackService.add(feedback);
            return "1";
        }catch (Exception e) {
            logger.error("添加反馈出错");
            return "0";
        }
    }

    //还需要Android的反馈相关

}
