package cn.jasonren.javalearn.serial;

import java.io.*;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午12:46
 * @email : zhicheng_ren@163.com
 */
public class Test implements Serializable{
    private static final long serialVersionUID = 1L;
    public static int staticVar = 5;

    public static void main(String[] args) {
        try{
            //初始时staticVar为5
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("result.obj")
            );
            outputStream.writeObject(new Test());
            outputStream.close();

            //序列化后修改为10
            Test.staticVar = 10;
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                "result.obj"
            ));
            Test t = (Test) oin.readObject();
            oin.close();

            System.out.println(t.staticVar);

        }catch( IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
