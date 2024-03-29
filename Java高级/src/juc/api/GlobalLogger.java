package juc.api;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/**
 * @Author qzy
 * @ClassName GlobalLogger
 * @Description 方便使用日志类
 * @Date 2022/10/20 8:37 星期四
 */
public class GlobalLogger {
    public static Logger getLog(String name) {
        return Logger.getLogger(name);
    }

}
