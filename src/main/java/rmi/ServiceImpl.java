package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程对象必须实现 UnicastRemoteObject，这样才能保证客户端访问获得远程对象时，
 * 该远程对象会把自身的一个拷贝以 Socket 形式传输给客户端，客户端获得的拷贝称为 stub，
 * 而服务器端本身已经存在的远程对象成为 skeleton，此时客户端的 stub 是客户端的一个代理，
 * 用于与服务器端进行通信，而 skeleton 是服务端的一个代理，
 * 用于接收客户端的请求之后调用远程方法来响应客户端的请求
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {

    private String name;

    public ServiceImpl(String name) throws RemoteException {
        this.name = name;
    }

    public String doService(String content) throws RemoteException {
        return "server >> " + content;
    }
}
