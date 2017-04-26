

RMI Demo 示例
===========================


Java Remote Method Invocation (RMI)为java远程调用中的最简单机制，实现了跨java虚拟机之间的通信（仅限JAVA间使用）。本示例主要演示RMI远程调用的机制，包括服务端、客户端以及远程调用的通用接口

****
###　　　　　　　　　　　　Author:Jason
###　　　　　　　　　 E-mail:372922638@qq.com

===========================

## 目录说明
* service-a 服务A：服务调用方
* remote 远程通用接口
* service-b 服务B：服务注册方

## 启动参数配置
### service-b

	-Djava.rmi.server.codebase=file:{workspace}/remote/target/classes/
	-Djava.rmi.server.useCodebaseOnly=false
	-Djava.rmi.server.hostname=localhost
	-Djava.security.policy={workspace}/server.policy

### service-a
	-Djava.rmi.server.codebase=file:{workspace}/client/target/classes/
	-Djava.security.policy={workspace}/client.policy

## 参数说明
* java.rmi.server.codebase：提供远程动态下载的资源路径
* java.rmi.server.useCodebaseOnly：默认为true, 表示仅依赖当前的codebase
* java.rmi.server.hostname：服务端对外的访问地址
* java.security.policy：设置安全策略的文件地址

## 参考
[https://docs.oracle.com/javase/tutorial/rmi/](https://docs.oracle.com/javase/tutorial/rmi/)
