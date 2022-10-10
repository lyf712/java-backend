package com.lyf.dubboprovider;

import com.lyf.dubboapi.EchoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liyunfei
 */
// dubbo贡献给apache了
//@Service
@Service
public class EchoServiceImpl implements EchoService {
    private final static Logger LOGGER = LoggerFactory.getLogger(EchoServiceImpl.class);
    // publishProvider interfaceName is empty
    @Override
    public String echo(String msg) {
        //org.apache.dubbo.rpc.service.EchoService
        LOGGER.info("[provider]"+msg);
        return "provider provide fun:receive msg:"+msg;
    }
}
