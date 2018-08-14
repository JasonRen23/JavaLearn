package cn.jasonren.javalearn.proxy;

/**
 * @author : Jason
 * @date : 2018-07-28 下午8:44
 * @email : zhicheng_ren@163.com
 */
public class HelloServiceProxy implements HelloService {

    private HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("记录日志");
        target.say();
        System.out.println("清理日志");
    }
}
