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

package com.lyf.sample.cache;

import com.lyf.sample.domain.entity.UserDO;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class UserInfoCache implements Cache<String, UserDO>{

    private static final ConcurrentHashMap<String,UserDO> USER_MAP = new ConcurrentHashMap<>(1024);

    private static final ConcurrentHashMap<String,Boolean> STATUS_CHECK_MAP = new ConcurrentHashMap<>(1024);

    @Override
    public UserDO get(String s) {

        return null;
    }

    @Override
    public void set(String s, UserDO userDO) {

    }
}
