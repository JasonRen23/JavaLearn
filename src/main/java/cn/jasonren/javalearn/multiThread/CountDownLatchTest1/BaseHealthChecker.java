package cn.jasonren.javalearn.multiThread.CountDownLatchTest1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午12:40
 */
public abstract class BaseHealthChecker implements Runnable {

    private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;

    public BaseHealthChecker(final CountDownLatch _latch, final String _serviceName) {
        this._latch = _latch;
        this._serviceName = _serviceName;
    }

    @Override
    public void run() {
        try {
            verifyService();
            _serviceUp = true;
        } catch (Throwable e) {
            e.printStackTrace();
            _serviceUp = false;
        } finally {
            if (_latch != null) {
                _latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return _serviceName;
    }

    public boolean isServiceUp() {
        return _serviceUp;
    }

    public abstract void verifyService();
}
