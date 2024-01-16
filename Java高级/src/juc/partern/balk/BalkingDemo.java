package juc.partern.balk;

/**
 * @author qzy
 * @time 2023/12/14 16:31 星期四
 * @title 犹豫模式
 */
public class BalkingDemo {
    private boolean isDone = false;

    public void doJob() {
        System.out.println("try to start work。。。");
        synchronized (this) {
            if (isDone) {
                System.out.println("Job is already Done, balking.");
                return;
            }
            isDone = true;
            System.out.println("---Job started.---");
        }
    }

    public static void main(String[] args) {
        BalkingDemo demo = new BalkingDemo();
        new Thread(demo::doJob).start();    //  任务只会执行1次
        new Thread(demo::doJob).start();
        new Thread(demo::doJob).start();
    }
}
