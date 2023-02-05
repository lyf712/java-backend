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

package com.lyf.jvm.gc;

/**
 * @author liyunfei
 **/
public class ReliveObj {
    private static ReliveObj obj;//GC roots

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行finalize");
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new ReliveObj();
        obj = null;//
        System.gc();//gc有可能免死--
        Thread.sleep(1000);
        if(obj==null){
            System.out.println("回收掉了");
        }else{
            System.out.println("还活着");
        }
        
    }
}
