package cn.jasonren.javalearn.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhicheng
 * @create 2018-07-19 下午5:54
 */


public class ClassLoaderTest {
    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader("/Users/jasonren/lib");
        try {
            Class c = diskClassLoader.loadClass("Jobs"); // 2
            if(c != null){
                try {
                    Object object = c.newInstance();
                    System.out.println(object.getClass().getClassLoader());
                    Method method = c.getDeclaredMethod("say", null);
                    method.invoke(object, null); //3
                }catch (InstantiationException | IllegalAccessException
                    | NoSuchMethodException
                    | SecurityException
                    | IllegalArgumentException
                    | InvocationTargetException e){
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
