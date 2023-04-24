package test.bridge;

/**
 * @Author qzy
 * @ClassName Shape
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:33 星期三
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    protected abstract void show();
}
