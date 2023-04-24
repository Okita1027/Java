package principle.合成复用.after;

/**
 * @Author qzy
 * @ClassName Car
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/17 10:42 星期一
 */
public abstract class Car {
    protected Color color;

    public Car(Color color) {
        this.color = color;
    }

    public abstract void run();
}
