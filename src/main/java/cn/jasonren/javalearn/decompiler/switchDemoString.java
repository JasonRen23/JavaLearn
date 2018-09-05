package cn.jasonren.javalearn.decompiler;

public class switchDemoString {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
            default:
                break;
        }
    }
}
