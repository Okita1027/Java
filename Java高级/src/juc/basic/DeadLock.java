package juc.basic;

/**
 * @author 秦智耘
 * @Title 死锁
 * @Date 2021年8月25日13:53:27
 */
public class DeadLock
{
    /*
    * 死锁：第一个线程运行时需要拿到一把锁才能继续，但这把锁已经被第二个线程拿去用了；
    * 而第二个线程在运行时又遇到了需要拿到第一个线程使用的锁才能继续运行的情况
    * 线程1运行中->线程1拿到了锁A继续运行->线程1需要拿到锁B才能继续运行
    * 线程2运行中->线程2拿到了锁B继续运行->线程2需要拿到锁A才能继续运行
    * 双方都要拿到对方持有的锁，但自己的锁又不能解除，就会形成死锁
    * 出现死锁的后果很严重，会直接导致程序卡死，不能继续往下运行
    * */
    public static void main(String[] args)
    {
        //模拟死锁的情况
        Lock A = new Lock(true);
        Lock B = new Lock(false);
        A.start();
        B.start();
    }

    static class Lock extends Thread
    {
        //lock继承Thread，这里使用static是为了保证多线程使用的是同一个对象
        static Object A = new Object();
        static Object B = new Object();
        boolean flag;

        public Lock(boolean flag)
        {
            this.flag = flag;
        }

        @Override
        public void run()
        {
            if (flag)
            {
                synchronized (A)
                {
                    System.out.println("AAA，线程名：" + Thread.currentThread().getName());
                    synchronized (B)
                    {
                        System.out.println("BBB，线程名：" + Thread.currentThread().getName());
                    }
                }
            }
            else
                synchronized (B)
                {
                    System.out.println("BBB" + Thread.currentThread().getName());
                    synchronized (A)
                    {
                        System.out.println("AAA" + Thread.currentThread().getName());
                    }
                }
        }
    }
}

