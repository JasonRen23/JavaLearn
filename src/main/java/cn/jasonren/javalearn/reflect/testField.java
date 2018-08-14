package cn.jasonren.javalearn.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author : JasonRen
 * @date : 2018-07-30 下午6:07
 * @email : zhicheng_ren@163.com
 */
public class testField {
    public static void main(String[] args) throws IllegalAccessException{
        List<String> obj = Arrays.asList(new String[]{"老马", "编程"});
        Class<?> cls = obj.getClass();
        for(Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " - " + f.get(obj));
        }
    }
}
