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

import com.lyf.sample.cache.PoolCache;
import com.lyf.sample.domain.dto.AdputResultDTO;
import com.lyf.sample.domain.dto.GoodsDTO;
import com.lyf.sample.domain.entity.Pool;
import com.lyf.sample.domain.entity.Rule;
import com.lyf.sample.service.PoolHandleService;
import com.lyf.sample.strategy.AbstractAdPutHandler;
import com.lyf.sample.strategy.factory.HandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
@Component
public class GoodsPoolHandleService implements PoolHandleService<GoodsDTO> {

    @Autowired
    private PoolCache poolCache;

    @Autowired
    private HandlerFactory handlerFactory;

    @Override
    public void handle(GoodsDTO goodsDTO) {
        // 过规则
        AdputResultDTO adputResultDTO = new AdputResultDTO();

        // 聚合规则--动态选择处理handler
        List<AbstractAdPutHandler> adPutHandlerList = handlerFactory.getAdPutHandlerList();
        for(AbstractAdPutHandler handler:adPutHandlerList){
           // handler.handle();
        }

    }

}
