package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Client
 * @Description 测试类
 * @Date 2022/6/19 10:23 星期日
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new BaoMaBuilder());
        Car car = director.construct();
        System.out.println(car.getFrame());
        System.out.println(car.getSeat());
    }
}
