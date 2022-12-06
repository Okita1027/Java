package juc.senior;


import java.util.logging.Logger;

/**
 * @Author qzy
 * @ClassName GlobalLogger
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/10/20 8:37 星期四
 */
public class GlobalLogger {

    public static Logger getLog(String name) {
        return Logger.getLogger(name);
    }

}
