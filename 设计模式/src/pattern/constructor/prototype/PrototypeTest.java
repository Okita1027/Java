package pattern.constructor.prototype;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName PrototypeTest
 * @Description 深克隆测试（颁发奖状）
 * @Date 2022/6/18 21:41 星期六
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType r1 = new RealizeType();
        RealizeType r2 = r1.clone();
        System.out.println("对象r1和r2是否为一个对象？" + (r1 == r2)); //false
        r1.setName("张三");
        r2.setName("李四");
        r1.show();
        r2.show();
    }
}
