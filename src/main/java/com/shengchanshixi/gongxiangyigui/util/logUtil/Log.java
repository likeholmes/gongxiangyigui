package com.shengchanshixi.gongxiangyigui.util.logUtil;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**模块*/
    String module() default "";

    /**描述*/
    String description() default "";

}