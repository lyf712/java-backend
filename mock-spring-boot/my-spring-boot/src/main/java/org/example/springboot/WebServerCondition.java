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

package org.example.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

/**
 * @author liyunfei
 **/
public class WebServerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String,Object> map = metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
        String className = (String) map.get("value");

        try {
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }
}
