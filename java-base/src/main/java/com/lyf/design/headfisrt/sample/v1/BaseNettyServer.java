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

package com.lyf.design.headfisrt.sample.v1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public abstract class BaseNettyServer {

    private static ServerBootstrap serverBootstrap;

    private static EventLoopGroup bossGroup;

    private static EventLoopGroup workGroup;

    // 设置策略
    abstract void setHandler();

    abstract void startServer();

}
