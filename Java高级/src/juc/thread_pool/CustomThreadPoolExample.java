package juc.thread_pool;

import java.util.concurrent.*;

/**
 * @author qzy
 * @time 2023/12/2 17:54 星期六
 * @title 自定义线程池
 */
public class CustomThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, // 核心线程数为5
                50, // 最大线程数为50
                0, TimeUnit.SECONDS, // 空闲线程存活时间
                new LinkedBlockingQueue<>() // 任务队列使用无界队列
        );

        for (int i = 1; i <= 5; i++) {
            executor.execute(new TicketSeller("窗口" + i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class TicketSeller implements Runnable {
        private String windowName;
        private static int totalTickets = 100;

        public TicketSeller(String windowName) {
            this.windowName = windowName;
        }

        @Override
        public void run() {
            while (totalTickets > 0) {
                System.out.println(windowName + " 卖出一张票，剩余票数：" + --totalTickets);
            }
        }
    }
}
