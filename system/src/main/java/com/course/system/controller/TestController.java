package com.course.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "success... ";
    }
}
