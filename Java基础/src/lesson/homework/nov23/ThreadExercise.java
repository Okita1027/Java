package lesson.homework.nov23;

/**
 * @author qzy
 * @time 2023/11/23 16:47 星期四
 * @title
 */
public class ThreadExercise {
    private static final Object lock = new Object();
    private static boolean numberTurn = true;

    public static void main(String[] args) {
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 52; i++) {
                synchronized (lock) {
                    while (!numberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    if (i % 2 == 0) {
                        numberTurn = false;
                    }
                    lock.notify();
                }
            }
        });

        Thread letterThread = new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                synchronized (lock) {
                    while (numberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(c);
                    if ((c - 'A' + 1) % 2 == 0) {
                        Thread.yield(); // 让出CPU，提高打印的并发性
                    }
                    numberTurn = true;
                    lock.notify();
                }
            }
        });

        numberThread.start();
        letterThread.start();
    }
}
