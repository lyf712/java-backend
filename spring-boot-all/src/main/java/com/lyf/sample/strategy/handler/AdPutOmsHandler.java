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

package com.lyf.sample.strategy.handler;

import com.lyf.sample.domain.dto.AdputResultDTO;
import com.lyf.sample.domain.entity.Pool;
import com.lyf.sample.domain.entity.Rule;
import com.lyf.sample.enums.PoolTargetTypeEnum;
import com.lyf.sample.strategy.AbstractAdPutHandler;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author liyunfei
 **/
@Component
public class AdPutOmsHandler extends AbstractAdPutHandler {

    @Override
    public void handle(Pool pool, Rule rule, Collection<PoolTargetTypeEnum> scope, AdputResultDTO adputResultDTO) {

    }

    @Override
    protected String handleType() {
        return "ad_put_oms";
    }

}
