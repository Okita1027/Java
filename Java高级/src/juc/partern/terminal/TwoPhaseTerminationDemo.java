package juc.partern.terminal;

/**
 * @author qzy
 * @time 2023/12/14 15:08 星期四
 * @title 2阶段终止Demo
 */
public class TwoPhaseTerminationDemo {
    private volatile boolean shutdownRequested = false;
    private final Thread workerThread;

    public TwoPhaseTerminationDemo() {
        this.workerThread = new Thread(() -> {
            while (!shutdownRequested) {
                // 线程执行的逻辑
                try {
                    Thread.sleep(1000);
                    System.out.println("Working...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // 第二阶段终止：清理工作
            System.out.println("Cleaning up...");
        });
        this.workerThread.start();
    }

    public void requestShutdown() {
        // 第一阶段终止：发送终止请求
        this.shutdownRequested = true;
        this.workerThread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTerminationDemo demo = new TwoPhaseTerminationDemo();

        // 模拟程序运行一段时间后需要终止
        Thread.sleep(3000);

        // 发送终止请求
        demo.requestShutdown();

        // 等待线程终止
        demo.workerThread.join();
        System.out.println("Terminated！");
    }
}
