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

package com.lyf.base.generic;

import java.util.List;

/**
 * @author liyunfei
 **/
public class PersonService<N> implements IService<Person>{

    //N[] ns = new N[5];
    //N n = new N();

    @Override
    public List<Person> getList() {


        return null;
    }

    @Override
    public <M> void set(M m) {
        // 运行这样使用了？？
        if(m instanceof Person){
            System.out.println("set success");
        }else{
            System.out.println("set fail");
        }
    }
}
