package juc.basic;

/**
 * @author 秦智耘
 * @Title 守护线程
 * @Date 2021年8月24日20:34:12
 */
@SuppressWarnings("all")
public class Deamon
{
    /*
    * 用户线程：也叫工作线程，当线程的任务执行完成或通知方式结束
    * 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
    * 常见的守护线程：垃圾回收机制
    * */
    public static void main(String[] args) throws InterruptedException
    {
        Work work = new Work();
        //如果我们希望在main线程结束之后work线程也随之结束
        //就用这条setDaemon方法，注意这条语句需要写在start方法之前，否则会出现异常
        work.setDaemon(true);
        work.start();
        for (int i = 0; i < 5; i++)
        {
            System.out.println("main线程运行中---");
            Thread.sleep(1000);
        }
    }
    static class Work extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    System.out.println("子线程运行中...");
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