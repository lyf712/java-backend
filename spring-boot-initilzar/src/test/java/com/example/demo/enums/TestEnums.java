package com.example.demo.enums;

import com.example.demo.model.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author liyunfei
 */
public class TestEnums {
    
    @Test
    public void testValues() {
        System.out.println(Arrays.toString(ConfigChangeTypes.values()));
        ConfigChangeTypes configChangeTypes = ConfigChangeTypes.PUBLISH;
        switch (configChangeTypes) {
            case PUBLISH:
            case REMOVE: {
                System.out.println("remove|publish");
                break;
            }
//            case PUBLISH: {
//                System.out.println("publish");
//                break;
//            }
            case IMPORT: {
                System.out.println("import");
                break;
            }
            default: {
                System.out.println("defalut");
            }
            
        }
    }
    
    void handle(Response response) {
        response.setMsg("ok");
    }
    
    @Test
    public void testRef() {
        Response response = new Response();
        System.out.println(response.getMsg());
        handle(response);
        System.out.println(response.getMsg());
    }
    
}
