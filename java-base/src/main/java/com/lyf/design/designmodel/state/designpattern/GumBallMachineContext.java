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

package com.lyf.design.designmodel.state.designpattern;

/**
 * @authorliyunfei
 * @date2022/11/5
 **/
public class GumBallMachineContext implements Context{
    State delegate;

    // 自动去委托，，策略模式是动态主动去添加策略
    public GumBallMachineContext(State delegate) {
        this.delegate = delegate;
    }

    @Override
    public void request() {
        delegate.handle();
    }
}
