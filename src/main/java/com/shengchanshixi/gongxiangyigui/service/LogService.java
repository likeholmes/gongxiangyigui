package com.shengchanshixi.gongxiangyigui.service;

import com.shengchanshixi.gongxiangyigui.entity.Log;
import org.aspectj.lang.JoinPoint;

import java.util.List;

public interface LogService {
    void put(JoinPoint joinPoint, String methodName, String module, String description);

    List<Log> findAll();

}
