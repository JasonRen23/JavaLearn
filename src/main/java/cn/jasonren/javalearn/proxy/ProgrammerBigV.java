package cn.jasonren.javalearn.proxy;

import java.lang.reflect.Proxy;

/**
 * @author : Jason
 * @date : 2018-07-28 下午8:00
 * @email : zhicheng_ren@163.com
 */
public class ProgrammerBigV implements Programmer {
    private Jason jason;

    public ProgrammerBigV() {
        this.jason = new Jason();
    }

    public void upvote() {
        System.out.println("程序员大V点赞评论收藏转发！");
    }

    public void addMoney() {
        System.out.println("这次我要加100块");
    }

    @Override
    public void coding() {
        //让Jason发文章
        jason.coding();

        //程序员大V点赞评论收藏转发！
        upvote();

        //加价
        // addMoney();
    }

    // public static void main(String[] args) {
    //
    //     Programmer programmer = new ProgrammerBigV();
    //
    //     programmer.coding();
    // }

    public static void main(String[] args1) {
        Jason jason = new Jason();

        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(jason.getClass().getClassLoader(),
            jason.getClass().getInterfaces(), (proxy, method, args) -> {

            //如果是调用coding方法，那么水军就要点赞了
            if (method.getName().equals("coding")) {
                method.invoke(jason, args);
                System.out.println("我是水军，我来点赞了！");
            } else {
                //如果不是调用coding方法，那么调用原对象的方法
                return method.invoke(jason, args);
            }

            return null;
        });

        //每当JasonRen写完文章，水军都会点赞
        programmerWaterArmy.coding();
    }
}

