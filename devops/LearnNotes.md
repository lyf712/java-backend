# DevOps概述

# 一、学习说明

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d9fbb542-9791-4202-b818-af41c0b89e3c/Untitled.png)

### 软件的四大本质问题

- 复杂性
- 可变性
- 一致性
- 不可见性

## 软件的发展

### 软硬件一体化（50-70s）

- 硬件很贵、服务与科学计算-数学家和科学家
- 功能单一
- Code & fix、软件危机和软件工程（60年代末）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6c004307-fcad-4b68-9041-6766153b574f/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/72844ced-3c80-4039-a817-dc1646be097c/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e95bd5e3-c065-4c54-a6e2-d00a3435219e/Untitled.png)

### 软件独立阶段（70-90）

- 出现OS、有了PC
- 复杂性提升、需求多变
- 出现结构化设计、形式化设计、瀑布模型

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/abeeeb7c-048f-4424-a609-2be832bf7b1c/Untitled.png)

### 网络化和服务化（90至今）

- 规模化很大
- 用户量激增（几个亿）
- 需求多变、不确定性
- 迭代式方法

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c578dc2b-e36e-4614-9d14-87b04382192d/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/97ab5eb7-f5d5-4733-817f-576e10dc5588/Untitled.png)

云计算：容器技术、硬件抽象问题基础设施（计算类）

云原生：DevOps、持续交付、微服务、容器

大数据：上层算法、分析应用

一些常见概念辨析、理解


# 敏捷开发方法

# 一、学习目标

## 学习大纲

- 敏捷开发的基本内容（概念及敏捷宣言）
- 看板（工作流及 Limit WIP)：结合飞书及常用的看板
- 精益

# 二、学习目录

## 敏捷开发概念

### 背景

DevOps：2010年左右提出来；敏捷2001年左右就提出来了；目前学术界和工业界都推崇DevOps采用敏捷开发方法；

运维工程师提出-；（应对需求变化块，）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1978fd60-a4a6-42ca-8a66-3714dad335b6/Untitled.png)

敏捷开发宣言:

- 个体和交互
- 可工作的软件
- 客户的合作
- 响应变化

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d208125a-053b-4165-97cd-390a72dfb89e/Untitled.png)

发展历史：

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c3be35cb-42a0-4743-93e8-6deb1a73ce36/Untitled.png)

**知识体系：**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2503d064-c5be-4f7c-bbe5-8b5af0fe71a7/Untitled.png)

## 看板-kanban

### 基本定义

- 增量渐进性

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f8b56cbb-319e-42cf-ba21-617d29ce59a7/Untitled.png)

物理白板；kanban:信号白板

要点：工作流（可视化工作流），WIP（限制在制品）

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/37ae864c-94fd-41e3-a783-6527db6d8d85/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06900417-b22a-4916-bc26-c834f076e603/Untitled.png)

WIP上限：若有阻塞，先解决阻塞问题；

- 帮助发现问题、发现人员阻塞情况

## 精益-Lean

### 概念

敏捷出现与软件开发，精益出现在制造业；将精益利用到软件开发。

精益的基本特点：

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8d2ada8f-b9d9-4962-b4c8-76e54de1d91e/Untitled.png)

- 减除浪费（开发不必要功能、不必要的设计-过度设计、团队相互等待（WIP就是解决该问题）…）