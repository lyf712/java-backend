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

package com.lyf.design.designmodel.factory.headfirst;

/**
 * @authorliyunfei
 * @date2022/11/9
 **/
// 基本的需求：披萨，点餐
abstract class Pizza{
    abstract void pox();
}
class ChinesePizza extends Pizza{
    @Override
    void pox() {

    }
}

// --

class Requirement{
      Pizza createPizza(String type){
          Pizza pizza = null;
          // 该处代码 -- 每次创建对象则会进行 判断 ，提升复用性；则需要封装起来
          // 理解封装的本质作用--（1）提升复用性（辨别通用性\公用），底层与上层，（2）降低耦合度，SRP各司其职，减少不必的耦合
          // (3)易于理解，便于维护 （4）应对变化（变化的发生位置，动态运行时、编译时；业务变化时---）--
          // 抽象：则是稳定，例如中间件，OS等思想都是抽象稳定抽象层，其实也会有封装的感觉

          // ======.抽离重复diam.分配专门的类去处理该职责（类职责的来源处理重复公用，工具类型，module--common） ======
          if("cheesePizza".equals(type)){
              pizza = new ChinesePizza();
          }else if("other..".equals(type)){
              // other type...
          }
          // ======.======

          // pizza operation...
          pizza.pox();
          return pizza;
      }
}

class SimpleFactory {
       public static Pizza createPizza(String type){
           Pizza pizza = null;
           if("cheesePizza".equals(type)){
               pizza = new ChinesePizza();
           }else if("other..".equals(type)){
               // other type...
           }
           return pizza;
       }
}

// 需要在口味上进行变更拓展
interface Factory{
    // Pizza 最好改为interface
    Pizza createPizza();// 为了保证可chinese、产地这个维度还需要继续传参-type,类似而抽象工厂则 在此处进行抽象稳定-针对变化拓展
}
class AFactory implements Factory{
    @Override
    public Pizza createPizza() {
        //return new ;//AProduct
        return null;
    }
}

interface AbstractFactoryInterface{//将type展开来
    // 抽象的--
    Pizza createChinesePizza();
    // other--产地
}

class AbstractAFactory implements AbstractFactoryInterface{
    @Override
    public Pizza createChinesePizza() {
        return null;
    }
}

public class Factories {

}