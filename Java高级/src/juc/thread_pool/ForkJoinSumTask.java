package juc.thread_pool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

/**
 * @author qzy
 * @time 2023/12/6 15:37 星期三
 * @title Fork/Join框架实现累加案例
 */

public class ForkJoinSumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 100;
    private int[] array;
    private int start;
    private int end;

    public ForkJoinSumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * 计算数组中指定范围内元素的总和。
     * 如果范围长度小于等于阈值，则直接计算总和。
     * 否则，将范围分为两半，并将左半部分和右半部分分别交给两个子任务计算。
     * 最后将两个子任务的结果相加作为结果返回。
     * @return 数组中指定范围内元素的总和
     */
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long total = 0;
            for (int i = start; i < end; i++) {
                total += array[i];
            }
            return total;
        } else {
            int mid = (start + end) / 2;
            ForkJoinSumTask leftTask = new ForkJoinSumTask(array, start, mid);
            ForkJoinSumTask rightTask = new ForkJoinSumTask(array, mid, end);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }


    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + i;
        }
        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new ForkJoinSumTask(array, 0, array.length));
        System.out.println("Sum: " + result);
    }
}