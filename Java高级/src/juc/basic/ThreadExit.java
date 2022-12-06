package juc.basic;

/**
 * @author 秦智耘
 * @Title 通知线程退出
 * @Date 2021年8月23日14:04:26
 */
@SuppressWarnings({"all"})
public class ThreadExit
{
    public static void main(String[] args) throws InterruptedException
    {
        thread01 thread01 = new thread01();
        thread01.start();
        //让thread01线程10秒后退出
        Thread.sleep(10000);
        thread01.setFlag(false);
    }
}

class thread01 extends Thread
{
    private boolean flag = true;

    @Override
    public void run()
    {
        int count = 0;
        while (flag)
        {
            System.out.println("次数" + (++count) + "： thread01运行中! 当前线程名：" + Thread.currentThread().getName());
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
}