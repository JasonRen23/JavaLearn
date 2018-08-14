package cn.jasonren.javalearn.threadExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author : JasonRen
 * @date : 2018-08-04 下午8:56
 * @email : zhicheng_ren@163.com
 */
public class ConnectionDriver {

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
            new Class<?>[] {Connection.class},
                ((proxy, method, args) -> {
                    if(method.getName().equals("commit")){
                        TimeUnit.MICROSECONDS.sleep(100);
                    }

                    return null;
                })
            );
    }
}
