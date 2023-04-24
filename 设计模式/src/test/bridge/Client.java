package test.bridge;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:47 星期三
 */
public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(new Blue());
        circle.show();
    }
}
