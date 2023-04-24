package principle.合成复用.before;

/**
 * @Author qzy
 * @ClassName ElectricCar
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/17 10:39 星期一
 */
public class ElectricCar extends Car {
    @Override
    protected void move() {
        System.out.println("电车出发！");
    }
}
