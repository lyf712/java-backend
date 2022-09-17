# 线程并发基础篇

# 目录

# 一、概念部分

## CPU核数、线程数

1. 关于位宽，内存，最大寻址的问题
- 虚拟内存 = min{最大CPU寻址，磁盘外存大小}
- 当操作系统一般为32bit或64bit;32bit的最大内存可以为4G；理论上64bit的最大内存为 2^34 G,可实际上的64bit内存一般为128、256G；

原因：主板限制（木桶效应）, 相关讨论： [https://www.zhihu.com/question/29962475/answer/1644236272](https://www.zhihu.com/question/29962475/answer/1644236272)

> 64位架构（windows的）下，地址线是46个，所以最大的物理地址是2^46B，折合64TB，可用地址空间也是这么大（目前为止）
>

1. CPU核心数、线程数
- 为了实现并发或并行，有两种途径（CMP-多核心角度，STM-多线程角度）
- 核数和线程数的关系：一般为1:1，在引入超线程后为1:2

查看核数：

- linux:   于 /proc/cpuinfo文件中： processor:线程数， codeid:核心数      cat /proc/cpuinfo
- 注：在使用cat /proc/cpuinfo时，单核则显示一个核的信息，多核就显示过个 （截图如下）

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6a10a548-d920-4220-a09d-52bc3c808725/Untitled.png)

- Java：可通过 getRuntime().availableProcessors()获取
- 注：nacos在PropertiesUtils中设计使用到，见以下截图

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/abb835e0-add9-4495-b7fb-44cd38fa8633/Untitled.png)


## 时间片机制（RR调度）

1. 时间片的基本概念

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f57ad5af-ff3f-4e54-ae5e-01f58871f98d/Untitled.png)

掌握要点：

- 理解**进程（而不是线程）**的状态及其转换、管理机制（相关队列）
- 理解上下文切换和时间片的协调（）上下文切换：CPU的利用效率，时间片：用户的响应速度 ；时间片：100ms适中
- [ ]  画进程状态模型图-结合进程队列、线程【待做】

## 进程、线程相关概念

1. 软件、系统、**程序、进程、线程（暂略）**

## 并行、并发相关概念

1. 并行、并发（暂略）

- 计算并发量的示例

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9db3c6d-1c19-454d-b4c2-7314813e7a33/Untitled.png)

- 吞吐量的概念

对于系统吞吐量：

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/631b8619-caca-4469-b27a-e8b75d78778b/Untitled.png)

1. 同步、异步

## 为什么需要并发编程及注意事项

1. 背景需求角度
- 海量数据处理、多用户

1. 优点特性（实则也是为需求而生）
- 充分利用CPU资源
- 加快响应速度
- 代码模块化、异步化、简单化

1. 注意点
- 线程安全问题：由于线程可用通信，共享资源，则在多个进行写操作，会存在线程安全问题
- 死锁问题：由于线程安全引入锁，需要防止死锁
- 资源耗尽导致死机：线程数过多时会导致 **内存泄露 ？ 资源耗尽  —** 采用资源库设计，数据库连接采用该设计

# 二、认识Thread

### Java中的线程转换（结合进程状态模型）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ba659328-ecab-4417-9a28-bc6003a3a4fe/Untitled.png)

- [ ]  画图理解+Java代码练习

### Java线程的实现方式（严格来说三种，广泛是四种）

相关参考博客：[https://blog.csdn.net/bj_ameng/article/details/115266696](https://blog.csdn.net/bj_ameng/article/details/115266696)

1. Java中Thread的实现方式

- 继承Thread : 只能继承一个父类—思考局限？？ —- 实际上实现run本来也无需复用多个？？
- 实现Runnable接口：
- 实现Callable接口：
- 采用线程池Executors：

1. **线程组**的使用【可归纳为Thread的基本使用中】

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/44484407-ef1e-492d-a45e-ffe48470d287/Untitled.png)

构造函数：**private ThreadGroup() ；public ThreadGroup(String name)**; 为什么这样设计？

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b2ca946e-0c88-4139-8044-2020d953bf1b/Untitled.png)

### Thread的基本API和使用

1. 基本API

官方文档： [https://docs.oracle.com/javase/8/docs/api/](https://docs.oracle.com/javase/8/docs/api/)

1. 中断机制

注：Java并没有提供安全终止线程的方法

（1）采用Thread.stop():已不推荐使用

（2）采用interrupt机制

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1f987a09-f0d6-4f07-8922-2e1f4f28ff8f/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/03d10a14-ee18-4e8c-bc76-a8b3f187153e/Untitled.png)

1. 守护线程

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/96185248-9913-46d1-baa9-02334ad78565/Untitled.png)

1. 线程的异常处理
- [ ]  结合异常处理机制学习

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e6eb83ac-f450-4d09-b287-ca15ce9bf0db/Untitled.png)

### 线程副本ThreadLocal

1. 【最清晰】ThreadLocal和局部变量和成员变量的区别
   ThreadLocal是进程级别的全局变量。
   最近有⼀个疑惑：为什么线程类的局部变量不能完全替代ThreadLocal，每⼀次new 线程都是创建了⼀个副本啊照理来说也是独⽴的，为什么还需要ThreadLocal。实际上确实是独⽴的，但是答案是ThreadLocal还有更⼴泛的⽤途。

- 第⼀种情况：
  当想在不同线程，访问“同⼀个对象的⽅法”，希望以线程作为区分，区分⼀个变量的作⽤域，⽽希望这个⽅法根据线程不同⽽作出不同处理，这时就需要threadLocal（⽽不能⽤类成员变量，为啥呢，因为同⼀个对象，它的成员变量是⼀样的）。
- 第⼆种情况：
  那为啥不⽤函数局部变量呢，因为⼜考虑到函数间局部变量不便于共享（试想如果⼀个线程执⾏了多个⽅法，他们如果想共享变量，如果是局部变量，则必须要不断传参，这样特别⿇烦，于是有了ThreadLocal，根据当前在哪个线程⽽获得变量）
  想必读到这⾥，⼤家已经了解了ThreadLocal的使⽤场景了吧，实际上在使⽤ThreadLocal时时刻记得它是以线程为作⽤域的，就不会出错啦，⽽那些局部变量和成员变量的滥⽤，会导致程序可读性变差，⽽多线程时也有可能因为作⽤域⽽产⽣意想不到的奇怪问题。
1. 原理概述
   ThreadLocal维护⼀个静态map，key是线程，value是table数组。所以不同线程得到的table不同。

# 三、线程安全

### 初步了解JMM

1. 背景
- 关于计算机的内存模型机制：内存 → 高速缓存 → 寄存器，由于有些数据使用频繁，因此就会放在缓存，而不是都从主存拿数据。
- JMM机制：主存+工作内存；主内存：堆存储，共享静态变量等；工作内存：局部变量，拷贝副本
- 多线程同时操作时带来的问题点：  数据的可见性，操作的时序性

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ead3443b-081c-44dd-9ed0-4edae19cbb1b/Untitled.png)

1. 两大问题
- 可见性问题

（1）将主内存复制变量到工作内存（read and load）

（2）执行代码，修改共享变量（use and sign)

（3）将工作内存刷新到主内存（store and write)

- 时序性问题

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/74d22635-55db-4e3f-8cd6-6e3d41ba6837/Untitled.png)

### 线程安全问题

1. 不安全

> 当多个线程修改同一数据结构（可为集合，也可为变量）时，产生的数据不一致性问题，线程不安全。
>

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e5e6a08c-6bd3-41c5-bfa6-b56d02f06e3b/Untitled.png)

1. 线程安全

> 和线程不安全相反，每次都能保证一样的结果，保证数据的高度一致性和准确性。
>

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/897ca58f-1658-424f-a0c6-0f30a9664cda/Untitled.png)

保证的方式：

- synchronized : 加锁
- locks: ReetrantLock
- concurent下的包（atomic）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/16a6df4e-ea66-4d3c-9645-27c8235baa43/Untitled.png)

### 隐式锁 - 线程同步锁 synchronized

1. 基本概念

Java自带的关键字（底层原理？—），保证线程同步，需要抢锁

1. synchronized的加锁位置

（1）加在方法声明处（加在静态方法则是锁该类，加在非静态则是该对象）

（2）代码块：

- 锁住对象（this,Object)：尽量使用分配内存较小的对象，例如 byte；抢锁释放锁，需要资源，对象越大资源处理越大。
- 锁住静态类( .class)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/12cfdec4-6b67-4dde-b3ce-05e437ea0a63/Untitled.png)

1. 加锁的规则（考虑静态、非静态和加锁方式）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4d99a23a-8e81-4f2d-9b1c-b5805fc060b6/Untitled.png)

当加锁在 .class时锁住整个类，静态方法都不能用；而锁在 object只是该对象，静态方法是能够用的，；当存在静态方法时一般会采用加锁 .class

**四种加锁情况**： [https://baike.baidu.com/item/synchronized/8483356?fr=aladdin](https://baike.baidu.com/item/synchronized/8483356?fr=aladdin)

- 加在this: 所有该对象都不能被调用
- 加在obejct: 加了该对象锁的地方不能用
- 加在.class: 包括静态方法、静态变量都不能用

### 显示锁 - Lock, ReentrantLock, StampledLock

1. Lock及ReentrantLock

1. ReadWriteReetrantLock

ReadLock的意义在于保证读取的顺序性。

1. **StampedLock**

### 什么是死锁

### volatile和atomic

1. volatile的作用
- 保证可见性：读取时是从内存地址拿数据，而非缓存，但并没有保证原子性，因为没有使其立刻写回内存

注：加锁即保证原子性也保证可见性。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/701ae27c-961a-4880-a7dd-a0e4786d3a12/Untitled.png)

1. atomic

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d6294676-1c89-43e5-a246-7556ee9dfb0a/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eefee28a-f64d-4db4-9231-a4dcf32af43b/Untitled.png)

实现原理：

CAS算法，底层CPU指令实现

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/aede30bc-00b5-41bb-b81f-d56eda841dd8/Untitled.png)

# 四、线程安全集合类

- [ ]  待分析

1. Hashtable 和 ConconrrentHashmap

1. CopyOnwirteArraysList\Set

1. Vector