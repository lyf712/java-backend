package com.lyf.sample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liyunfei
 */
@RestController
@RequestMapping("/webhook")
public class WebHookServerController {
    @PostMapping("/send")
    String webhook(HttpServletRequest request, HttpServletResponse response, @RequestBody Object o) {
        System.out.println(o);
        return "test";
    }
}
