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

package com.lyf.sample.config;

import org.apache.http.HttpHost;
import org.elasticsearch.action.*;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.threadpool.ThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration
public class EsRestClientConfig {

    @Value("spring.elasticsearch.uris")
    private String esHost;

    @Bean
    RestClient restClient(){
        ElasticsearchClient client = new ElasticsearchClient() {
            @Override
            public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(Action<Response> action, Request request) {
                return null;
            }

            @Override
            public <Request extends ActionRequest, Response extends ActionResponse> void execute(Action<Response> action, Request request, ActionListener<Response> actionListener) {

            }

            @Override
            public ThreadPool threadPool() {
                return null;
            }
        };
        return RestClient.builder(HttpHost.create(esHost)).build();
    }
}
