package juc.basic;

/**
 * @author 秦智耘
 * @Title 线程的中断
 * @Date 2021年8月23日19:23:20
 */
@SuppressWarnings({"all"})
public class Interrupt_
{
    public static void main(String[] args) throws InterruptedException
    {
        /*
        * interrupt：用于中断线程的休眠，即停止休眠，继续执行线程内容
        * 这就是sleep要被捕获异常的原因
        * */
        wallpaper wallpaper = new wallpaper();
        //常用方法：
        wallpaper.setName("壁纸引擎");  //设置线程名称，默认为Thread-0 (0++)
        wallpaper.start();
        //wallpaper.setPriority(Thread.MIN_PRIORITY); //设置该线程的优先级为最低
        //wallpaper.getName();    //获取线程名
        //wallpaper.getState()    //获取线程当前的状态

        for (int i = 0; i < 25; i++)
        {
            System.out.println("Hello!");
            Thread.sleep(500);
        }
        //中断休眠,原本“壁纸引擎”线程在执行完20次循环后要再过10秒才会开始下一次循环
        //这条语句相当于取消了它的休眠状态，让他在主线程输出25次循环后，立即开始执行线程的内容
        wallpaper.interrupt();
    }

    static class wallpaper extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                for (int i = 0; i < 20; i++)
                {
                    System.out.print("切换壁纸" + i);
                    System.out.println(",线程名：" + Thread.currentThread().getName());
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("线程中断！");
                        e.printStackTrace();
                    }
                }
                try
                {
                    //让这个线程过10秒再运行
                    System.out.println(Thread.currentThread().getName() + "正在休眠……");
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    System.out.println(Thread.currentThread().getName() + "被interrupt（中断）了");
                }
            }
        }
    }
}

