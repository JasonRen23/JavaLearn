package cn.jasonren.javalearn.hystrix;

import com.netflix.hystrix.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午8:42
 * @email : zhicheng_ren@163.com
 */
public class CommandUser extends HystrixCommand<String> {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandUser.class);

    private String userName;

    public CommandUser(final String userName) {
        super(Setter.withGroupKey(
            //服务分组
            HystrixCommandGroupKey.Factory.asKey("UserGroup"))
            //线程分组
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
            //线程池配置
            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                .withCoreSize(10)
                .withKeepAliveTimeMinutes(5)
                .withMaxQueueSize(10)
                .withQueueSizeRejectionThreshold(10000))

            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
        );
        this.userName = userName;
    }

    @Override
    protected String run() throws Exception{
        LOGGER.info("userName=[{}]", userName);

        TimeUnit.MICROSECONDS.sleep(100);
        return "userName=" + userName;
    }
}
