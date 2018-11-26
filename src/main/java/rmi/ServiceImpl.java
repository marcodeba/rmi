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
        super();
        this.name = name;
    }

    public String doService(String content) throws RemoteException {
        return "server >> " + content;
    }
}

/**
 * rmic -keep ServiceImpl->ServiceImpl_Stub.java
public final class ServiceImpl_Stub
        extends java.rmi.server.RemoteStub
        implements IService, java.rmi.Remote {
    private static final long serialVersionUID = 2;

    private static java.lang.reflect.Method $method_doService_0;

    static {
        try {
            $method_doService_0 = IService.class.getMethod("doService", new java.lang.Class[]{java.lang.String.class});
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.NoSuchMethodError(
                    "stub class initialization failed");
        }
    }

    // constructors
    public ServiceImpl_Stub(java.rmi.server.RemoteRef ref) {
        super(ref);
    }

    // methods from remote interfaces

    // implementation of doService(String)
    public java.lang.String doService(java.lang.String $param_String_1)
            throws java.rmi.RemoteException {
        try {
            Object $result = ref.invoke(this, $method_doService_0, new java.lang.Object[]{$param_String_1}, -6150940093166659157L);
            return ((java.lang.String) $result);
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }
}
 */