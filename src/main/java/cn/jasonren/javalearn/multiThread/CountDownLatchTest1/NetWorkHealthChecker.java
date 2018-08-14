package cn.jasonren.javalearn.multiThread.CountDownLatchTest1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午12:44
 */
public class NetWorkHealthChecker extends BaseHealthChecker {
    public NetWorkHealthChecker(final CountDownLatch _latch) {
        super(_latch, "NetWork Service");
    }


    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try{
            Thread.sleep(7000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + "is Up");
    }
}
