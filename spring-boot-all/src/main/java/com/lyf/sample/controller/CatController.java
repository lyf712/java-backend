/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.sample.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Cat的基本使用.
 *
 * @author liyunfei
 **/
@RestController
@RequestMapping("/order")
public class CatController {
    @GetMapping("/test")
    public String get(){
        Transaction t = Cat.newTransaction("URL","cat_test");
        try {
            // Transaction.SUCCESS
            //Transaction.
            t.setStatus("handle");
            goodsRpc1();
            int i = 1/0;
        }catch (Exception e){
            t.setStatus(e);
        }finally {
            t.complete();
        }
        return "ok";
    }

    public void goodsRpc1(){
        Transaction t = Cat.newTransaction("GOODS_SERVICE_1","cat_test");
        goodsRpc2();
        t.complete();
    }

    public void goodsRpc2(){
        Transaction t = Cat.newTransaction("GOODS_SERVICE_2","cat_test");
        t.complete();
    }

}
