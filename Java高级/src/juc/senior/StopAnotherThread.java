package juc.senior;

import java.util.logging.Logger;

/**
 * @Author qzy
 * @ClassName StopAnotherThread
 * @Description 在线程A中停止线程B
 * @Date 2022/10/19 20:06 星期三
 */
@SuppressWarnings("all")
public class StopAnotherThread {
    static Logger logger = Logger.getLogger("TwoPhaseTermination");

    public static void main(String[] args) throws InterruptedException {
        logger.info("StopAnotherThread...");
        TwoPhaseTermination termination = new TwoPhaseTermination();
        termination.start();
        Thread.sleep(3500);
        termination.stop();
    }
    static class TwoPhaseTermination{

        private Thread monitor;

        //启动监控线程
        public void start() {
            monitor = new Thread(() -> {
                while (true) {
                    Thread currentThread = Thread.currentThread();
                    if (currentThread.isInterrupted()) {
                        logger.info("料理后事……");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        logger.info("执行监控……");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //设置打断标记
                        currentThread.interrupt();
                    }
                }
            }, "monitor");
            monitor.start();
        }

        //停止监控线程
        public void stop() {
            monitor.interrupt();
        }
    }
}
