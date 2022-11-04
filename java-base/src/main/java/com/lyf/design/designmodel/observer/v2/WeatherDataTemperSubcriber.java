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

package com.lyf.design.designmodel.observer.v2;

/**
 * @authorliyunfei
 * @date2022/11/4
 **/
public class WeatherDataTemperSubcriber implements Subcriber<WeatherData>{
    private float temperature;
    @Override
    public void update(WeatherData weatherData) {// 这样写 ，订阅的主题过大？，存在数据结构内聚
        temperature = weatherData.getTemperature();
        System.out.println("已更新温度数据："+temperature);
    }
    public void display(){

    }
}
