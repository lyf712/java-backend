package com.lyf.sentinel.consumer;

import org.springframework.stereotype.Service;

/**
 * @author liyunfei
 */
@Service
public class LocalService {
    String localService(String param){
        return "localService"+param;
    }
}
