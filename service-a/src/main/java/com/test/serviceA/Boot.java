package com.test.serviceA;

import com.test.remote.RemoteService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端 - 调用远程对象
 * Created by jason-geng on 2/11/17.
 */
public class Boot {

    private static final String REMOTE_P1 = "serviceB:p1";
    private static final int REGISTRY_PORT = 9999;

    public static void main(String[] args) throws RemoteException {

        System.setProperty("java.security.policy", "/Users/jason-geng/Code/study/rmi-simple-rpc/service-a/server.policy");
        System.setProperty("java.rmi.server.codebase", "file:/Users/jason-geng/Code/study/rmi-simple-rpc/service-a/target/service-a-1.0-SNAPSHOT.jar");

        //设置连接超时时间
        System.setProperty("sun.rmi.transport.tcp.handshakeTimeout", "1000");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
            RemoteService p1 = (RemoteService) registry.lookup(REMOTE_P1);
            String res1 = (String)p1.run();
            System.out.printf("The remote call for %s %s \n", REMOTE_P1, res1);

            Object param = new ParamObj();
            String res2 = (String)p1.run(param);
            System.out.printf("The remote call for %s %s \n", REMOTE_P1, res2);
        } catch (NotBoundException e){
            e.printStackTrace();
        } catch (RemoteException e){
            e.printStackTrace();
        }

    }
}
