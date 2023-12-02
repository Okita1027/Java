package juc.basic;

import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author qzy
 * @ClassName Park
 * @Description 使用LockSupport的park方法打断线程执行
 *              park过后，无法再次park，必须在二者之间使用Thread.interrupted()重置打断状态
 * @Date 2022/10/19 21:16 星期三
 */
@SuppressWarnings("all")
public class Park {
    private static Logger logger = Logger.getLogger("Park");
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            logger.info("park...");
            LockSupport.park();
            logger.info("unpark...");
            Thread.interrupted();
            logger.info("重置打断状态为false");
            LockSupport.park();
            logger.info("park");
        }, " t1");
        t1.start();

        Thread.sleep(1);
        t1.interrupt();

        Thread.sleep(1000);
        System.exit(1);
    }
}
