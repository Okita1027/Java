package juc.exercise;

/**
 * @author 秦智耘
 * @Title 练习2
 * @Date 2021年8月25日15:13:21
 */
public class ExerciseMoney {
    /*
     * 两个用户从一个卡上取钱（总额：10000）
     * 每一次取出1000，余额不足时，不能取款
     * 不能出现超取现象
     * */
    public static void main(String[] args) {
        Money money = new Money(10000);
        Thread thread0 = new Thread(money);
        Thread thread1 = new Thread(money);
        thread0.start();
        thread1.start();
    }

    static class Money implements Runnable {
        private int money;

        public Money(int money) {
            this.money = money;
        }

        @Override
        public void run() {
            synchronized (this) {
                while (money >= 1000) {
                    money -= 1000;
                    System.out.println("取出了1000元，剩余" + money + "元");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}