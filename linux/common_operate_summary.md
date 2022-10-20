# Linux常用操作

# 一、基础操作

## 目录结构

## 软件安装

### 安装的基本逻辑与原理

1. 寻找安装包（自行网络寻找，包管理工具-rpm）— 镜像源
2. 进行解压或编译 （联系Java、C++等编译过程） → 可执行文件
3. 进行相关配置（例如环境变量）: 常见软件的安装配置在/etc
4. 进行执行（service,systemctl,./bin/ )

### 安装的基本指令

centos: `yum install -y app_name`

ubuntu: `apt install app_name`

包管理：rpm,

其他：`wget` url 下载相应的文件.tar.gz，并解压缩（一般针对中间件，rpm管理无的）

`tar -zxvf your_package`

## 环境配置

### 配置主机别名、映射IP

`/etc/hostname`

`/etc/hosts`

便于进行简化，和域名同IP一样的思路

### 配置环境变量

编辑 `/etc/profile`  ，或/bash_ ?

- Java环境变量

`export JAVA_HOME=/usr/local/software/jdk1.8.0_341
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=export CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib`

时其生效：

`source /etc/profile`

### 配置网络IP

文件夹：/etc/sysconfig/network-scripts/

配置文件：

TYPE=””

dhcp:

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f98e3057-253a-4662-9670-f4df9552dec9/Untitled.png)

---

static:

IPADDR=””

NETMASK=””

GATEWAY=””

TYPE="Ethernet"

BOOTPROTO="static"

NAME="ens33"

UUID="2fb4447d-68d6-4597-aec0-353a6b1452e6"

DEVICE="ens33"

ONBOOT="yes"

IPADDR="192.168.75.100"

NETMASK="255.255.255.0"

GATEWAY="192.168.75.2"

### 配置SSH、互联

前置安装：openssh-server

`ssh-keygen` : 生成私钥和公钥

`ssh-copy-id` :

进行一些文件互传：

`scp` ：scp [-r] host1_path root@ip:/host2_path

sftp协议

`ssh [localhost](http://localhost)` :校验

## 用户管理

### 用户权限

常见问题：Permission denied

- 文件的执行权限

`chmod` :

- 文件权限所有者

`chown`:

- 密码设置

passad?

- 用户\组的添加与删除

## 网络管理

- Linux

端口占用情况，进程启动情况

ifconfig:

ping:

tracert:

netstat -aux

ss -lnt

- windows

## 进程管理

`kill -9 pid` ：关闭进程

`ps` :查看进程情况

`top`: 检查资源情况

## Vim编辑器