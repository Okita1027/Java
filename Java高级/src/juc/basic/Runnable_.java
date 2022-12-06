package juc.basic;

/**
 * @author 秦智耘
 * @Title Runnable
 * @Date 2021年8月23日13:03:14
 */
@SuppressWarnings({"all"})
public class Runnable_
{
    /*
    * Java 是单继承的，在某些情况下，一个类可能已经继承了某个父类，但又想让他继承Thread类做多线程，这显然不可能
    * Java 提供了另一个方式创建线程，通过实现Runnable接口来创建线程
    * 实现Runnable与继承Thread本质上没有区别，因为Thread实现了Runnable
    * 但实现Runnable接口更加适合多个线程共享一个资源的情况，避免了单线程的限制
    * */
    public static void main(String[] args)
    {
        cartoon cartoon = new cartoon();
        //由于cartoon实现的Runnable接口没有start方法，所以要换种方式实现多线程
        //创建Thread对象，由于cartoon实现了Runnable接口，而Thread也是实现Runnable接口的，所以括号内可以填cartoon
        Thread thread = new Thread(cartoon);
        thread.start();
    }
}
class cartoon implements Runnable
{
    //重写run方法即描述此线程要做什么事情
    @Override
    public void run()
    {
        int count = 0;
        while (true)
        {
            System.out.println("次数" + (++count) + "： Cartoon Start! 当前线程名：" + Thread.currentThread().getName());
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