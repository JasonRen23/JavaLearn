package cn.jasonren.javalearn.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:44
 * @email : zhicheng_ren@163.com
 */
public class demo1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("jason");
        stringList.add("ren");
        String str1 = stringList.get(0);
        stringList.get(1);
    }
}
