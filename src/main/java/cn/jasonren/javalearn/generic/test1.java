package cn.jasonren.javalearn.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : JasonRen
 * @date : 2018-08-03 下午11:29
 * @email : zhicheng_ren@163.com
 */
public class test1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没?");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
}

