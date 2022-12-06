package juc.basic;

/**
 * @author 秦智耘
 * @Title 线程基础
 * @Date 2021年8月22日22:26:35
 */
/*
 * 单线程：一个时刻只允许执行一个线程
 * 多线程：同一个时刻，可以执行多个线程；如一个QQ同时打开多个聊天，一个迅雷同时下载多个文件
 * 并发：同一时刻，多个任务交替运行，由于CPU工作的速度极快，看起来就是“同时进行”的。 单核CPU实现的多任务就是并发
 * 并行：同一个时刻，多个任务同时执行，现在的CPU基本都是多核的，所以可以真正实现并行
 * */
@SuppressWarnings({"all"})
public class Thread_
{
    /* 当程序开始运行时，创建一个应用程序，main方法即此应用程序中的一个线程
     * 整个程序的结束不以main方法中的事务执行完毕而结束，而是所有线程的事务都执行完毕之后才结束
     * 在这个程序中main方法循环50次结束，而另外一个线程则要循环80次才结束
     * 两个线程交替执行，main50次执行完成后，run还有30次要执行，等run执行完，整个程序才终止
     * 不仅main中可以创建线程，其它线程也可以创建线程
     * 在程序运行时，可以在 控制台 输入Jconsle查看线程的状态
     */
    public static void main(String[] args) throws InterruptedException
    {
        game game = new game();
        //用start而不是run，因为直接用run，那就是主线程main调用一个普通的方法执行而已
        //它会把run方法执行完后再执行main方法中后续的内容，这样就不算多线程了
        /* start方法底层调用了一个start0方法，start0是真正运行的线程的方法
         * 但start0只是把线程变为可运行状态，具体什么时候执行，由CPU决定
         * start0是本地方法，是由 JVM 调用的，底层是用C/C++实现的
         * JVM调用了start0之后，会根据不同的操作系统进行调度，最终给CPU执行
         */
        game.start();//启动线程 -> 最终会执行run方法
        //其它线程不会影响主线程，主线程继续执行
        System.out.println("主线程继续进行");
        //主线程中做的事情，此线程要执行50次
        for (int i = 0; i < 50; i++)
        {
            System.out.println("这是主线程中运行的内容，线程名：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
//当一个类继承了Thread类，它就可以当做一个线程使用
class game extends Thread
{
    //重写run方法即描述此线程要做什么事情
    @Override
    public void run()
    {
        int count = 0;
        while (true)
        {
            System.out.println("次数" + (++count) + "： Game Start! 当前线程名：" + Thread.currentThread().getName());
            //sleep方法有异常，用try-catch包裹起来
            try
            {
                //sleep方法：让这个线程间隔一秒再运行
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (count == 80)    //此线程一共要执行80次
                break;
        }
    }
}
