package juc.basic;

/**
 * @author 秦智耘
 * @Title 线程的礼让和插队
 * @Date 2021年8月24日10:15:10
 * yield：线程的礼让，让出CPU,让其他线程执行，但礼让的时间不确定
 * 例如当前CPU工作量不大，不需要礼让，所以礼让不一定成功
 * join：线程的插队，插队的线程一旦成功，则会优先执行完插队线程中的所有内容再回头执行其它内容
 */
public class JoinYield
{
    public static void main(String[] args) throws InterruptedException
    {
        NetBar netbar = new NetBar();
        netbar.start();
        int k = 40;
        for (int i = 0; i < 20; i++)
        {
            Thread.sleep(1000);
            System.out.println("主线程（+++小弟+++）上" + (k--) + "号机子");
            if (i == 10) {
                netbar.join();  //子线程插队（大哥先上机，小弟等大哥都上机了再上机）
            }
        }
    }
}

class NetBar extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("子线程（===大哥===）上" + i + "号机子");
        }
    }
}