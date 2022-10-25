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
 * @authorliyunfei
 * @date2022/10/25
 **/
public abstract class BaseDuck {

    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // 基本行为
    void swim(){

    }
    // 易变化且子类不一定有的行为
//    abstract void fly();
//    // 采用策略 分离，需要拥有直接实现接口
//    abstract void quack();

    // 子类拓展的行为
    abstract void sing();

}
