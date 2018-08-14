package cn.jasonren.javalearn.multiThread.CountDownLatchTest1;

/**
 * @author JasonRen
 * @since 2018/8/13 上午12:58
 */
public class Main {
    public static void main(String[] args) {
        boolean result = false;
        try{
            result = ApplicationStartupUtil.checkExternalServices();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: " + result);
    }

}
