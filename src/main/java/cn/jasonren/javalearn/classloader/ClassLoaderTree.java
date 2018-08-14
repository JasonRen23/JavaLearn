package cn.jasonren.javalearn.classloader;

/**
 * @author zhicheng
 * @create 2018-07-19 下午4:44
 */


public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null){
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
