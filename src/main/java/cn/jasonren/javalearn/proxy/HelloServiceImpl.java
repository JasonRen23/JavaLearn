package cn.jasonren.javalearn.proxy;

/**
 * @author : Jason
 * @date : 2018-07-28 下午8:44
 * @email : zhicheng_ren@163.com
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
