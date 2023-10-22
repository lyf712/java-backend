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

package com.lyf.collections;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author liyunfei
 **/
public abstract class AbstractPluginManager<T> {

    //private final static Logger
    protected Collection<T> basePlugins;

    private void init(){
        basePlugins= new LinkedHashSet<>();
    }

    abstract void joinPlugin(T t);

    void addBasePlugin(T t){basePlugins.add(t);}

    void batchJoin(Collection<T> collection){
        for (T t :collection){joinPlugin(t);}
    }



}
