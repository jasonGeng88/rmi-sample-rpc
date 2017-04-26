package com.test.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jason-geng on 4/25/17.
 */
public interface RemoteService extends Remote {

    Object run() throws RemoteException;

    Object run(Object obj) throws RemoteException;

}
