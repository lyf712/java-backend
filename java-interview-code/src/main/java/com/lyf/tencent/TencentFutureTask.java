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

package com.lyf.tencent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liyunfei
 **/
public class TencentFutureTask {

    byte[] bytes = new byte[1024 * 1024 *4];

    public static void main(String[] args) {
        FutureTask<Boolean> futureTask = new FutureTask<>(() -> {

            return false;
        });

    }

}
