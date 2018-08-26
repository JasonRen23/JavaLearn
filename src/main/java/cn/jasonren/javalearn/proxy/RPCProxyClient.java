package cn.jasonren.javalearn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RPCProxyClient implements InvocationHandler {
    private Object obj;

    public RPCProxyClient(final Object obj) {
        this.obj = obj;
    }

    public static Object getProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new RPCProxyClient(obj));
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) {
        Object result = new Object();

        return result;
    }

    public static void main(String[] args) {
        HelloService helloService = (HelloService) RPCProxyClient.getProxy(HelloService.class);
        helloService.say();
    }
}
