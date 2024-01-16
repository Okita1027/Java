package juc.partern.sequence_control;

/**
 * @author qzy
 * @time 2023/12/14 14:10 星期四
 * @title
 */
public class SequentialExecution {
    private boolean flag = false;

    public synchronized void stepOne() throws InterruptedException {
        while (flag) {
            wait();
        }
        System.out.println("Step One");
        flag = true;
        notifyAll();
    }

    public synchronized void stepTwo() throws InterruptedException {
        while (!flag) {
            wait();
        }
        System.out.println("Step Two");
        flag = false;
        notifyAll();
    }

    public static void main(String[] args) {
        SequentialExecution exe = new SequentialExecution();
        new Thread(() -> {
            try {
                exe.stepOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                exe.stepTwo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
