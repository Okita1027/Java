package lesson.homework.Oct27;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author qzy
 * @time 2023/10/30 10:03 星期一
 * @title
 */
public class SetList {
    public static void main(String[] args) {
        /* 题目1 */
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Date());
        list.add("string");
        list.add(new Circle(1));
        for (Object o : list) {
            System.out.println(o);
        }

    }
}

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double Area() {
        double s;
        s = Math.PI * this.radius * this.radius;
        return s;
    }

    public String toString() {
        return "次圆的半径是" + this.radius + "面积是" + this.Area();
    }
}