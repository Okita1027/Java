package juc.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qzy
 * @time 2023/12/2 16:59 星期六
 * @title WorkStealingPool
 */
public class WorkStealingPoolDemo {
    public static void main(String[] args) {
        // 创建一个基于工作窃取算法的线程池
        ExecutorService executor = Executors.newWorkStealingPool();

        // 提交任务给线程池
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
        }
    }
}
