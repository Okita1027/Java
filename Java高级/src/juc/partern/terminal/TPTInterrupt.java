package juc.partern.terminal;

/**
 * @author qzy
 * @time 2023/12/14 15:01 星期四
 * @title 2阶段终止
 */
public class TPTInterrupt {
    private Thread thread;
    public void start(){
        thread = new Thread(() -> {
            while(true) {
                Thread current = Thread.currentThread();
                if(current.isInterrupted()) {
                    System.out.print("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("将结果保存");
                } catch (InterruptedException e) {
                    current.interrupt();
                }
                // 执行监控操作
                System.out.println("监视中……");
            }
        },"监控线程");
        thread.start();
    }
    public void stop() {
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        TPTInterrupt t = new TPTInterrupt();
        t.start();
        Thread.sleep(3500);
        System.out.println("stop！");
        t.stop();
    }
}
