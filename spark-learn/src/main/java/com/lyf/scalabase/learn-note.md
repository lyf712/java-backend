# 一、基本概念

- `函数式`编程的Java类似编程语言

理解以下几个点：

- trait、class、object、package等粒度
- 闭包的概念

---

1、case 关键词只用来修饰  class 和object，也就是说只有case class 和case object的存在 ，
而没有case trait 或者class **这一说

2、case object /class A 这个A 是经过序列化，而且继承了Product特性同时有toString,hashCode,copy,equals方法

3、case class 经常可以用于解析和提取

4、有参用case class ,无参用case object