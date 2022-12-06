package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName BaoMa
 * @Description 宝马建造者
 * @Date 2022/6/19 10:00 星期日
 */
public class BaoMaBuilder extends Builder {

    @Override
    public void buildFrame() {
        car.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        car.setSeat("真皮车座");
    }

    @Override
    public Car createCar() {
        return car;
    }
}
