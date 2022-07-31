package com.lyf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    String hello(){return "hello";}
}
