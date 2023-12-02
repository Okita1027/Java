package juc.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author qzy
 * @time 2023/11/30 16:31 星期四
 * @title 创建线程方式3：Callable
 */
public class CallableThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> taskCallAble = new FutureTask<>(mc);
        Thread thread = new Thread(taskCallAble);
        thread.start();
        System.out.println("第一次->mc->taskCallAble.get() =》 " + taskCallAble.get());
        System.out.println("第二次->mc->taskCallAble.get() =》 " + taskCallAble.get());

        FutureTask<Integer> task = new FutureTask<>(() -> 123);
        new Thread(task, "callable").start();
        System.out.println("task.get() = " + task.get());
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
                System.out.println("i = " + i + ";sum = " + sum);
            }
            return sum;
        }
    }
}
