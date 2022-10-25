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

package com.lyf.design.headfisrt;

/**
 * 未实现接口与实现的分离，实现行为的组合
 *
 * @authorliyunfei
 * @date2022/10/25
 **/
public class SubDuck1 extends BaseDuck implements Flyable,Quackable{

    @Override
    void sing() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void quack() {

    }
}
