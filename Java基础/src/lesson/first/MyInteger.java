package lesson.first;

/**
 * @author qzy
 * @time 2023/9/26 8:25 星期二
 * @title 自定义Integer
 */
public class MyInteger {
    private int value; // 存储int值

    // 构造方法，接受指定的int值
    public MyInteger(int value) {
        this.value = value;
    }

    // 获取int值
    public int getValue() {
        return value;
    }

    // 判断是否为偶数
    public boolean isEven() {
        return value % 2 == 0;
    }

    // 判断是否为奇数
    public boolean isOdd() {
        return value % 2 != 0;
    }

    // 判断是否为素数
    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 静态方法，判断是否为偶数
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    // 静态方法，判断是否为奇数
    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    // 静态方法，判断是否为素数
    public static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 静态方法，将数字字符数组转换为int值
    public static int parseInt(char[] chars) {
        int result = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            }
        }
        return result;
    }

    // 静态方法，将字符串转换为int值
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        MyInteger num1 = new MyInteger(17);
        MyInteger num2 = new MyInteger(24);
        char[] charArray = {'1', '2', '3', '4', '5'};
        String str = "9876";

        System.out.println("num1 is odd? " + num1.isOdd());
        System.out.println("num2 is even? " + num2.isEven());

        System.out.println("Is 13 prime? " + MyInteger.isPrime(13));
        System.out.println("Is 20 prime? " + MyInteger.isPrime(20));

        System.out.println("parseInt(charArray): " + MyInteger.parseInt(charArray));
        System.out.println("parseInt(\"" + str + "\"): " + MyInteger.parseInt(str));
    }
}