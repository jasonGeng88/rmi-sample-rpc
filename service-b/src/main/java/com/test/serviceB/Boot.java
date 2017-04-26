package com.test.serviceB;

import com.test.remote.RemoteService;
import com.test.serviceB.publishService.pService1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI服务端
 * 1.创建远程对象
 * 2.将远程对象注册进RMI Registry
 * 3.等待client远程调用
 * Created by jason-geng on 2/11/17.
 */
public class Boot {

    private static final String REMOTE_P1 = "serviceB:p1";
    private static final int REGISTRY_PORT = 9999;

    public static void main(String[] args) throws RemoteException {

        System.setProperty("java.security.policy", "/Users/jason-geng/Code/study/rmi-simple-rpc/service-b/server.policy");
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        System.setProperty("java.rmi.server.hostname", "localhost");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        /**
         * 内部创建RMI Registry,若无引用外部资源,可无需设置java.rmi.server.codebase (因为它共享server中的资源)
         * 外部创建RMI Registry （rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false &）
         * 设置java.rmi.server.useCodebaseOnly=false （默认为true, 表示仅依赖当前的codebase. 如需使用外部（client or server）的codebase, 需把此参数设为false）
         */
        Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);

        RemoteService p1 = new pService1();
        Remote stub1 = UnicastRemoteObject.exportObject(p1, 0);

        //采用相对路径注册远程对象
        registry.rebind(REMOTE_P1, stub1);

        //采用绝对路径注册远程对象（如rmi://IP:PORT/name）,若只写name,则使用默认IP,PORT
//        Naming.rebind(REMOTE_NAME, stub);

        System.out.println("service b bound");


    }
}