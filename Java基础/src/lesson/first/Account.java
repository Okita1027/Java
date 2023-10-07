package lesson.first;

import java.util.Date;

/**
 * @author qzy
 * @time 2023/9/23 18:18 星期六
 * @title 银行账户
 */
public class Account {
    private int id; // 账户ID
    private double balance; // 账户余额
    private static final double annualInterestRate = 0.05; // 年利率（所有账户共享）
    private final Date dateCreated; // 开户日期

    // 无参构造方法，创建默认账户
    public Account() {
        id = 0;
        balance = 0.0;
        dateCreated = new Date();
    }

    // 带参数的构造方法，创建带特定ID和初始余额的账户
    public Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        this.dateCreated = new Date();
    }

    // 获取账户ID
    public int getId() {
        return id;
    }

    // 设置账户ID
    public void setId(int id) {
        this.id = id;
    }

    // 获取账户余额
    public double getBalance() {
        return balance;
    }

    // 设置账户余额
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 获取年利率
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // 获取账户的开户日期
    public Date getDateCreated() {
        return dateCreated;
    }

    // 计算月利率
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // 从账户提取特定数额
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("余额不足，提取失败");
        }
    }

    // 向账户存储特定数额
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("存款金额必须大于零");
        }
    }

    public static void main(String[] args) {
        // 创建一个带特定ID和初始余额的账户
        Account account1 = new Account(1, 1000.0);

        // 存款和取款
        account1.deposit(300.0);
        account1.withdraw(200.0);

        // 获取账户信息
        System.out.println("账户ID: " + account1.getId());
        System.out.println("账户余额: " + account1.getBalance());
        System.out.println("年利率: " + Account.getAnnualInterestRate());
        System.out.println("开户日期: " + account1.getDateCreated());

        // 计算月利率
        double monthlyInterestRate = account1.getMonthlyInterestRate();
        System.out.println("月利率: " + monthlyInterestRate);
    }
}
