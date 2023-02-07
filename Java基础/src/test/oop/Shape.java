package test.oop;

/**
 * @Author qzy
 * @ClassName Shape
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/29 21:51 星期日
 */
public interface Shape {
    double area();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Triangle implements Shape {

    private double first;
    private double second;
    private double third;
    public Triangle(double first, double second, double third) {
        if (first + second > third && first + third > second && second + third > first) {
            this.first = first;
            this.second = second;
            this.third = third;
        } else {
            //不满足条件自动构造成最小边长的等边三角形
            first = Math.min(first, second);
            first = Math.min(first, third);
        }
    }

    @Override
    public double area() {
        //等边三角形
        if (first == second && second == third) {
            return Math.sqrt(3) * first * first / 4;
        }
        //普通三角形
        double half = (first + second + third) / 2;
        return Math.sqrt(half * (half - first) * (half - second) * (half - third));
    }

}
class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

/**
 * 圆锥
 */
class Circular implements Shape {
    private Circle circle;
    private double height;

    public Circular(Circle circle, double height) {
        this.circle = circle;
        this.height = height;
    }

    @Override
    public double area() {
        // S = πR^2 + πR√r^2+h^2
        return circle.area() + Math.PI * circle.getRadius() * Math.sqrt(circle.getRadius() * circle.getRadius() + height * height);
    }
}