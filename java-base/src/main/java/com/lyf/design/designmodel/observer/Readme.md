# 一、简述
## 关键词
- subject\observer
- publisher\subcriber
- 状态变化、监听、更新

## 生活场景

- 气象站案例：气象数据变化，则相应的站台展示则随意随着发生变化！
- GUI案例：监听事件变化，当某个按钮\或其他组件发生变化，则做出相应的改变！-- 对比回调的概念
- 发布订阅事件：微信、QQ订阅了某主题，当该主题有更新则进行推送至用户

## 基本关系

- one to many
- many to many(多主题对多观察者,注册到多个发布者去)

## 基本类图

## 好处优点

松耦合，

# 二、应用场景

- java.util包下内置 observable
- java.swing的GUI设计
- nacos的监听配置变更，notifyCentor
- redis的发布、订阅

# 三、思考

- 与消息队列、线程池、缓冲池Buffer的对比
- 更新的频率，何时以何种方式通知给观察者