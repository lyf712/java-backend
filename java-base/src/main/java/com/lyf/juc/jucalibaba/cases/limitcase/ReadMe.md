# 一、背景

- 并发，请求量十分大（而且是突发性或时段性）
- 来源于场景：秒杀、抢红包、购票等
- 本质是用户量大，产生多对少的竞争，而且还是规定时间段去竞争

# 二、基本手段

- 限流
- 熔断、降级（返回兜底）
- 拒绝服务（返回错误页面，类似降级，只是前端的展示--，也是面向失败设计）
- 静态化
- 排队或等待
- 异步处理（同排队类似，在用户的角度需要更长时间的反馈，此角度只是后端的处理方式）
---
- 缓存，将常用的数据更快获取，加快响应速度，降低IO开销。
- 并发协作处理（多线程的并发，系统模块的分布式）

对于后两者，实则是提升处理能力；前面则是控制，减弱前端用户的消耗。
  
# 三、限流的案例

## 基本算法
- 计数器（不可应对突发流量）
- 滑动窗口（窗口大小的粒度）
- 漏桶算法
- 令牌桶算法（可应对突发流量，guava包提供）

## 简单实战

HTTP接口+压测


