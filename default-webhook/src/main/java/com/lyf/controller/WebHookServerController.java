package com.lyf.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author liyunfei
 */
@RestController
@RequestMapping("/webhook")
public class WebHookServerController {
    
    @PostMapping("/send")
    String webhook(HttpServletRequest request, HttpServletResponse response, @RequestBody Object o) {
        System.out.println(o);
        //Map<String,Object> map = (Map<String, Object>) o;
        //System.out.println(map.get("data"));
        return "test";
    }
    
}
