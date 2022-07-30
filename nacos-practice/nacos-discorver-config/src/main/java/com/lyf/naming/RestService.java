package com.lyf.naming;

import com.alibaba.nacos.common.http.client.NacosRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyunfei
 */
@Service
public class RestService {
    //@Autowired
    NacosRestTemplate restTemplate;
    void test(){
        // restTemplate.post()
    }
}
