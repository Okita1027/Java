package pattern.structor.facade;

/**
 * @Author qzy
 * @ClassName TV
 * @Description 子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
 * @Date 2022/12/21 15:00 星期三
 */
public class Light {
    public void on() {
        System.out.println("开灯");
    }
    public void off() {
        System.out.println("关灯");
    }
}
