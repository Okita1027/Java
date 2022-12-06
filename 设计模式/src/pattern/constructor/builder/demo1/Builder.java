package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Builder
 * @Description 建造者
 * @Date 2022/6/19 10:01 星期日
 */
public abstract class Builder {
    protected Car car = new Car();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Car createCar();
}
