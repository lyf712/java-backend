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

package com.lyf.sample.service.strategy.factory;

import com.lyf.sample.domain.dto.ResultDTO;
import com.lyf.sample.domain.entity.Pool;
import com.lyf.sample.domain.entity.Rule;
import com.lyf.sample.service.strategy.AbstractAdPutHandler;
import com.lyf.sample.service.strategy.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liyunfei
 **/
@Component
public class HandlerFactory {

    @Autowired
    private List<AbstractAdPutHandler> adPutHandlerList;

    //@Autowired
    private List<Handler<Pool, Rule, ResultDTO>> handlers;

    public List<AbstractAdPutHandler> getAdPutHandlerList() {
        return adPutHandlerList;
    }
}
