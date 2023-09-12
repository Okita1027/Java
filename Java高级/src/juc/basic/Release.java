package juc.basic;

/**
 * @author 秦智耘
 * @Title 锁的释放条件
 * @Date 2021年8月25日14:17:06
 */
public class Release
{
    public static void main(String[] args)
    {
        /*
        * 释放锁的情况：
        * 1、当前线程的同步方法、同步代码块执行结束
        * 2、当前线程在同步代码块、同步方法中遇到了break、return
        * 3、当前线程在同步代码块，同步方法中出现了未处理的Error或Exception，导致异常结束
        * 4、当前线程在同步代码块，同步方法中执行了线程对象的wait()方法，当前线程暂停，将锁释放
        * */

        //下面操作不会释放锁：
        //1、当程序执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法
        //暂停当前线程的执行，不会释放锁
        //2、线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁
        //注意：suspend()和resume()方法已过时，在编写多线程程序时应尽量避免使用
    }
}
