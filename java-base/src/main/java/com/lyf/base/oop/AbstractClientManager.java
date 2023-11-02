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

package com.lyf.base.oop;

import java.util.Properties;

/**
 * @author liyunfei
 **/
public abstract class AbstractClientManager {

    protected Properties properties;

    // static

    protected  volatile boolean isInit = false;

    public AbstractClientManager(Properties properties) {
        if(!isInit){
            this.properties = properties;
            System.out.printf("Abstract Init ... %s %d %s\n",properties==null,System.currentTimeMillis(),isInit);
            isInit = true;
        }
    }
}
