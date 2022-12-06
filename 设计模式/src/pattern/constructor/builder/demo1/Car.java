package pattern.constructor.builder.demo1;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName Car
 * @Description 要构建的产品
 * @Date 2022/6/19 9:59 星期日
 */
public class Car {
    private String frame;
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
