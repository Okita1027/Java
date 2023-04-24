package test.bridge;

/**
 * @Author qzy
 * @ClassName Squre
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:34 星期三
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    protected void show() {
        System.out.println("正方");
    }
}
