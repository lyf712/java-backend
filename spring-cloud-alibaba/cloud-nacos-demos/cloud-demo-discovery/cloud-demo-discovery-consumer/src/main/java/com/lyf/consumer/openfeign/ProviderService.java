package com.lyf.consumer.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 关注一下feign的client
 *  Default implements Client 默认采用HttpURLConnection通信
 *
 * @author liyunfei
 */
@Component
@FeignClient("demo-discovery-provider")
public interface ProviderService {
    
    @GetMapping("/provider/test/{msg}")
    String test(@PathVariable("msg") String msg);
    // feign调用时PathVariable必须注明msg
}
