package com.lyf.dubboconsumer;

import com.lyf.dubboapi.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class CallController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CallController.class);
    //@Reference
    @Reference(check = false)
    EchoService echoService;
    
    @GetMapping("/call/test/{msg}")
    String test(@PathVariable("msg")String msg){
        LOGGER.info("[consumer]"+msg);
        return echoService.echo(msg);
    }
}
