package juc.senior;

/**
 * @Author qzy
 * @ClassName SynchronizedExec02
 * @Description 加锁的使用
 * @Date 2022/10/20 9:29 星期四
 */
@SuppressWarnings("all")
public class SynchronizedExec02 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread incr = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }, "incr");
        Thread decr = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        }, "decr");
        incr.start();
        decr.start();
        System.out.println("count = " + counter.getCount());
    }
}

class Counter {
    public Integer count;
    public Counter() {
        count = 0;
    }
    //加锁方式1
    public void increment() {
        synchronized (this) {
            count++;
        }
    }
    //加锁方式2：在方法上加锁的对象仍然是this对象，而不是方法
    public synchronized void decrement() {
        count--;
    }
    public Integer getCount() {
        synchronized (this) {
            return count;
        }
    }
    //加锁方式3：在静态方法上对Class对象进行加锁
    public static void rubbishMethod() {
        synchronized (Counter.class) {
            System.out.println("Counter.rubbishMethod");
        }
    }
}