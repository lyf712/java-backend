package com.lyf.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class TestVisitResource {
    @GetMapping("/testGet")
    public String testGet(){
        return "get ok!!";
    }
}
