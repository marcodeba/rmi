package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Server端bind时的形参是Remote
 */
public interface IService extends Remote {

    //声明服务器端必须提供的服务
    String doService(String content) throws RemoteException;
}