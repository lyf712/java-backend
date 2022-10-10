# 分布式配置实战

# 一、分布式配置

##学习关键点

- 配置拉取nacos注册中心的配置
- 动态刷新配置及其原理理解
- 配置的域模型及租户、组的概念、理解隔离作用
- 配置变更、历史记录的理解作用

## 基本步骤

- 搭建依赖工程（脚手架、自己maven搭配依赖、沙箱环境）
- 进行配置测试、调试（配置文件配置，启动类、业务\配置类）

配置文件的格式可参考：nacos的官网

## 简单获取配置

- 通过@Value ${}获取配置信息

${}本为获取本地的配置文件的信息，如何实现的从远处配置中心到本地的properties

→ 分析Spring的加载配置文件（properties属性的过程）、nacos的获取配置的过程（client|server模型，http通信&grpc通信）、nacos如何打通与spring的properties以及如何实现动态刷新（下一部分讨论）

## 自动刷新配置

### 动态刷新的测试现象

- nacos client进行长轮询监听配置变化
- 当发送变更，则返回—，具体格式见nacos官网
- 重启SpringApplication，与BootStrap应用上下文-
- 刷新property

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/71010235-6d89-422a-b858-dee6c5fc2975/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/07442418-07e5-48b4-acb2-b2a898da3a44/Untitled.png)

## 高级配置

- 配置的域模型的设计：租户隔离
- 运维监控、开启：`actuator`