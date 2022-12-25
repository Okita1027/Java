package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Director
 * @Description 指挥者：用于指挥建造什么
 * @Date 2022/6/19 10:09 星期日
 */
public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.car;
    }
}
