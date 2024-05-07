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

package com.lyf.concurrent.binghe.design.chapter3;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liyunfei
 **/
public class AlarmTest {
    @Test
    public void testReport1(){
        AlarmReporter alarmReporter = new AlarmReporter();
        AtomicInteger id = new AtomicInteger(1);
        List<AlarmInfo> alarmInfos = Stream
                .generate(() -> {
                    AlarmInfo alarmInfo = new AlarmInfo();
                    alarmInfo.setId(String.valueOf(id.getAndIncrement()));
                    alarmInfo.setType(AlarmTypeEnum.INFO);
                    alarmInfo.setMsg("test");
                    return alarmInfo;
                })
                .limit(100)
                .collect(Collectors.toList());
        alarmReporter.reportWrongImpl1(alarmInfos);
    }
}
