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

import com.lyf.sample.domain.entity.Pool;
import com.lyf.sample.domain.entity.Rule;
import com.lyf.sample.excutors.CoreExecutors;
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
public class PoolCache {

    private static final Map<Pool, Collection<Rule>> POOL_MAP =new ConcurrentHashMap<>(64);

    private static final Collection<Pool> POOLS = new LinkedHashSet<>();

    @PostConstruct
    void init(){
        CoreExecutors.executeAtFixed(new Runnable() {
            @Override
            public void run() {

            }
        },5);
    }

    public List<Pool> getPools(){
        return (List<Pool>) POOLS;
    }
}
