package juc.basic;

/**
 * @author 秦智耘
 * @Title Synchronized:线程同步机制
 * @Date 2021年8月24日21:03:25
 */
@SuppressWarnings({"all"})
public class Synchronized_ {
    /*
     * synchronized使用方法：
     * 1:obj叫做同步监视器（即锁对象），任何线程进入下面同步代码块之前必须先获得对obj的锁
     * 一旦任意一个线程获得锁，其他线程便无法获得锁，获得锁的线程开始执行代码块
     * synchronized(obj)
     * {需要实现同步的代码块}
     * 2:直接修饰方法,此方法在同一时刻只能有一个线程在调用
     * 例：public synchronized void run(){}
     * 注意：线程同步会使程序效率变低，就算要实现同步，也应尽量使用 同步代码块 的方式而非 同步方法
     * */
    public static void main(String[] args) {
        /*
         * 此程序要实现3个线程使用同一个对象进行售票
         * 总共20张票，卖完为止
         * */
        SellTicket sellticket = new SellTicket();
        new Thread(sellticket, "A").start();
        new Thread(sellticket, "B").start();
        new Thread(sellticket, "C").start();
    }

    //实现Runnable接口而不是继承Thread类，因为Runnable适用于多个线程使用同一个对象的情况
    //多个线程的锁对象也必须是同一个，否则每个对象都有自己的锁，实现synchronized也没有意义了
    static class SellTicket implements Runnable {
        private static int nums = 20;
        private static boolean flag = true;
        private static Object obj = new Object();

        //这是一个同步方法，这时锁在this对象
        public /*synchronized*/ void sell() //1:直接修饰方法
        {
            while (flag) {
                //2:修饰代码块
                synchronized (/*this*/obj) {
                    if (nums > 0) {
                        System.out.println(Thread.currentThread().getName() + "窗口售票中（剩余" + (nums--) + "张票)");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        flag = false;
                    }
                }
            }
        }

        //同步方法没有使用static修饰，默认锁对象为this
        //如果使用了static，则默认锁对象为 当前类名.class

        //静态方法的锁不同于非静态方法，它的锁是加在 sellticket(当前类名).class中的
        public synchronized static void hello() {
            //若在静态方法实现一个同步代码块,括号中要写 当前类名.class
            synchronized (SellTicket.class) {
            }
        }

        @Override
        public void run() {
            sell();
        }
    }
}
