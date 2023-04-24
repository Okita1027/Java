package test.decorator;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/18 15:36 星期二
 */
public class Client {
    public static void main(String[] args) {
        BirthdayPresent cake = new Cake("普通蛋糕");
        System.out.println(cake.getDescription());
        cake = new Mongo(cake);
        System.out.println(cake.getDescription());
        cake = new Mongo(cake);
        System.out.println(cake.getDescription());

    }
}
