package cn.jasonren.javalearn.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午8:50
 * @email : zhicheng_ren@163.com
 */
public class CommandTest {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandTest.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        CommandOrder commandPhone = new CommandOrder("手机");
        CommandOrder command = new CommandOrder("电视");

        //阻塞方式执行
        String excute = commandPhone.execute();
        LOGGER.info("execute=[{}]", excute);

        //异步阻塞方式
        Future<String> queue = command.queue();
        String value = queue.get(200, TimeUnit.MILLISECONDS);
        LOGGER.info("value=[{}]", value);

        CommandUser commandUser = new CommandUser("张三");
        String name = commandUser.execute();
        LOGGER.info("name=[{}]", name);


    }
}
