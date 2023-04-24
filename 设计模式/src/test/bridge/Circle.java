package test.bridge;

/**
 * @Author qzy
 * @ClassName Circle
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:41 星期三
 */
public class Circle extends Shape{
    public Circle(Color color) {
        super(color);
    }

    @Override
    protected void show() {
        color.style("圆");
    }
}
