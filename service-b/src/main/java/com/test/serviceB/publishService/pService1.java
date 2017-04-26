package com.test.serviceB.publishService;

import com.test.remote.RemoteService;
import java.rmi.RemoteException;

/**
 * Created by jason-geng on 4/25/17.
 */
public class pService1 implements RemoteService {

    public Object run() {
        System.out.println("invoke pService1.");
        return "success";
    }

    public Object run(Object obj) throws RemoteException {
        System.out.println("invoke pService1, params is " + obj.toString());
        return "success";
    }

}
