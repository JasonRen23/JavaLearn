package cn.jasonren.javalearn.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : JasonRen
 * @date : 2018-07-29 下午3:07
 * @email : zhicheng_ren@163.com
 */
public class CglibProxy implements MethodInterceptor {
    //实例化一个增强器，也就是cglib中的一个class generator
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置目标类
        enhancer.setSuperclass(clazz);
        //设置拦截对象
        enhancer.setCallback(this);
        //生成代理类实例
        return enhancer.create();
    }
    @Override
    public Object intercept(final Object o, final Method method, final Object[] objects, final MethodProxy methodProxy) throws Throwable {
        System.out.println("before method was called");
        //进行被代理类的方法调用
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("after method was called");
        return res;
    }
}
