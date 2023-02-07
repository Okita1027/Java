package test.program;

/**
 * @Author qzy
 * @ClassName AccountUtil
 * @Description 看最下面的toSeparateNumber方法
 * @Date 2023/1/27 21:52 星期五
 */
public class AccountUtil {
    public static void main(String[] args) {
        System.out.println("1234567890.123456");
        System.out.println(toSeparateNumber("1234567890.123456"));
        System.out.println("1234567890");
        System.out.println(toSeparateNumber("1234567890"));
        final AccountUtil accountUtil = new AccountUtil();
        accountUtil.setId("1");
//        accountUtil.deposit(2);//账号未知
        accountUtil.setOwner("qzy");
        accountUtil.deposit(2000);
//        accountUtil.withdraw(2222);//余额不足
    }

    private String id;
    private String owner;
    private double balance;

    public AccountUtil() {
    }

    public AccountUtil(String id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double deposit(double amount) {
        if (owner == null) {
            throw new RuntimeException("账号未知！");
        }
        return amount;
    }

    public double withdraw(double amount) {
        if (owner == null) {
            throw new RuntimeException("账号未知！");
        }
        if (balance < amount) {
            throw new RuntimeException("余额不足！");
        }
        return amount;
    }

    @Override
    public String toString() {
        return "AccountUtil{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }

    //以 , 分隔大数字
    public static String toSeparateNumber(String str) {
        final StringBuilder stringBuilder = new StringBuilder(str);
        final int point = stringBuilder.lastIndexOf(".");
        int last;
        //lastIndexOf没找到的时候返回值是-1
        if (point != -1) {
            //找到小数点，则下标定位到小数点
            last = point;
        } else {
            //没找到小数点，则下标定位到末位的后一位
            last = stringBuilder.length();
        }
        //当前位置往左挪三位插入 ,
        for (int i = last - 3; i > 0; i -= 3) {
            stringBuilder.insert(i, ',');
        }
        return String.valueOf(stringBuilder);
    }

}
