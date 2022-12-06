package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName TeSiLaBuilder
 * @Description 特斯拉建造者
 * @Date 2022/6/19 10:08 星期日
 */
public class TeSiLaBuilder extends Builder {

    @Override
    public void buildFrame() {
        car.setFrame("白银车架");
    }

    @Override
    public void buildSeat() {
        car.setSeat("黄金宝座");
    }

    @Override
    public Car createCar() {
        return car;
    }
}
