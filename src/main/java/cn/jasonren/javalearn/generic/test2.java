package cn.jasonren.javalearn.generic;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:09
 * @email : zhicheng_ren@163.com
 */
public class test2 {
    public static void main(String[] args) {
        ObjectTool<String> tool = new ObjectTool<>();

        tool.setObj(new String("renzhicheng"));
        String s = tool.getObj();
        System.out.println(s);


        ObjectTool<Integer> objectTool = new ObjectTool<>();
        objectTool.setObj(10);
        int i = objectTool.getObj();
        System.out.println(i);
    }
}
