package cn.jasonren.javalearn.proxy;


import org.junit.Test;

/**
 * @author : Jason
 * @date : 2018-07-28 下午8:46
 * @email : zhicheng_ren@163.com
 */
public class Main {

    @Test
    public void testProxy(){
        //目标对象
        HelloService target = new HelloServiceImpl();
        //代理对象
        HelloServiceProxy proxy = new HelloServiceProxy(target);
        proxy.say();
    }

    @Test
    public void testCglibProxy(){
        CglibProxy proxy = new CglibProxy();
        Cat catProxy = (Cat) proxy.getProxy(Cat.class);

        catProxy.say();
    }

}
