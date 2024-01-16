package juc.exercise;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author qzy
 * @time 2023/12/18 15:54 星期一
 * @title
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    int num;

    public ForkJoinDemo(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num == 1) {
            return 1;
        }
        ForkJoinDemo t1 = new ForkJoinDemo(num - 1);
        t1.fork();
        System.out.println("fork()->" + num + t1);
        int result = num + t1.join();
        System.out.println("fork()->" + num + t1 + result);

        return result;
    }

    @Override
    public String toString() {
        return "ForkJoinDemo{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println("pool.invoke(new ForkJoinDemo(5)) = " + pool.invoke(new ForkJoinDemo(5)));
    }
}
