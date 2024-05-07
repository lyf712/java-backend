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

package com.lyf.sample.service.impl;

import com.lyf.sample.dao.mapper.UserMapper;
import com.lyf.sample.domain.entity.UserDO;
import com.lyf.sample.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liyunfei
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) throws Exception{
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("参数错误");
        }
        List<UserDO> userDOS = userMapper.queryUserBySchoolName(username);
        if (userDOS == null || userDOS.isEmpty()) {
            return false;
        }
        List<UserDO> collect = userDOS.stream().filter(userDO -> userDO != null && userDO.getEmail().equals(password)).collect(Collectors.toList());
        return collect.size() == 1;
    }
}
