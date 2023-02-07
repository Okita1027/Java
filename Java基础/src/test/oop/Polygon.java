package test.oop;

/**
 * @Author qzy
 * @ClassName Polygon
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/30 20:15 星期一
 */
public class Polygon {

    private int[] side;

    public Polygon(int[] side) {
        this.side = side;
    }

    void print() {
        System.out.print(side.length + "边形，边长为：");
        for (int i = 0; i < side.length; i++) {
            System.out.print(side[i] + "\t");
        }
    }
}
