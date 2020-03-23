# Nacos

https://nacos.io/zh-cn/docs/what-is-nacos.html

## 什么是Nacos

Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。Nacos 帮助您更敏捷和容易地构建、交付和管理微服务平台。 Nacos 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施,它相当于是springcloud的eureka + config + bus

## 下载Nacos

 https://github.com/alibaba/nacos/releases 

## 安装Nacos

    cd /opt
    tar -zxvf nacos-server-1.1.4.tar.gz
    mv nacos /usr/local/
    cd /usr/local/
    cd nacos/bin/

## **启动**Nacos

启动命令(standalone代表着单机模式运行，非集群模式): 

```tex
sh startup.sh -m standalone
```

集群模式启动

~~~linux
sh startup.sh
~~~

##  访问Nacos

http://192.168.198.129:8848/nacos 

默认账号和密码都是 nacos

## 服务的端点检查

spring-cloud-starter-alibaba-nacos-discovery 在实现的时候提供了一个 EndPoint, EndPoint 的访问地址为 

http://ip:port/actuator/nacos-discovery

## 服务中心对比

![image](https://github.com/heylaopao/springcloud-alibaba/blob/master/img/duibi.png)

## 支持mysql

 https://github.com/heylaopao/springcloud-alibaba/blob/master/sql/nacos-mysql.sql 

在0.7版本之前，在单机模式时nacos使用嵌入式数据库实现数据的存储，不方便观察数据存储的基本情况。0.7版本增加了支持mysql数据源能力，具体的操作步骤：

- 1.安装数据库，版本要求：5.6.5+
- 2.初始化mysql数据库，数据库初始化文件：nacos-mysql.sql
- 3.修改conf/application.properties文件，增加支持mysql数据源配置（目前只支持mysql），添加mysql数据源的url、用户名和密码。

```
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://192.168.198.129:3306/nacos_configcharacterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=root
```

启动nacos，nacos所有写嵌入式数据库的数据都写到了mysql

# 集群模式

![image](https://github.com/heylaopao/springcloud-alibaba/blob/master/img/jiegou.png)

## 配置集群配置文件

在nacos的解压目录nacos/的conf目录下，有配置文件cluster.conf，请每行配置成ip:port。（请配置3个或3个以上节点）

```plain
# ip:port
200.8.9.16:8848
200.8.9.17:8848
200.8.9.18:88s48
```

# =============== 项目搭建 ==============

## pom.xml

~~~xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
~~~

## yml

~~~yml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.198.129:8848
~~~

## main

~~~java
@EnableDiscoveryClient
~~~

