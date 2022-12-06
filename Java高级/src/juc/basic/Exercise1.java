package juc.basic;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 秦智耘
 * @Title 练习1
 * @Date 2021年8月25日14:25:53
 */
public class Exercise1
{
    /*
    * 在main线程中启动2个线程
    * 第一个线程循环打印100以内的数字
    * 直到第二个线程从键盘读取 ‘Q’
    * */
    public static void main(String[] args)
    {
        T1 t1 = new T1(true);
        T2 t2 = new T2(t1);
        t1.start();
        t2.start();
    }
}

class T1 extends Thread
{
    private boolean flag;

    public T1(boolean flag)
    {
        this.flag = flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        Random rdm = new Random();
        while (flag)
        {
            synchronized (this)
            {
                try
                {
                    System.out.println(rdm.nextInt(100));
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
class T2 extends Thread
{
    private final T1 t;
    public T2(T1 t)
    {
        this.t = t;
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.print("停止此线程请输入Q：\n");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q')
            {
                t.setFlag(false);
                break;
            }
        }
    }
}