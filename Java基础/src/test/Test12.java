package test;

import org.junit.jupiter.api.Test;

/**
 * @Author qzy
 * @ClassName Test12
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/4 21:33 星期三
 */
public class Test12 {

    @Test
    public void test01() {
        try {
            Circle circle1 = new Circle(1);
            Circle circle2 = new Circle(-1);
        } catch (IllegalArgumentException e) {
            try {
                e.printStackTrace();
                throw new NullPointerException("null");
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Circle.num = " + Circle.num);
    }

    @Test
    public void test02() {
        class A {
            int a;
            void method() {
                System.out.println("a = " + a++);
            }
        }
        A a = new A();
        a.method();
    }

    private class Circle {
        private double radius;
        private static int num;

        public Circle(double radius) {
            setRadius(radius);
            num++;
        }

        public void setRadius(double radius) throws IllegalArgumentException {
            if (radius >= 0) {
                this.radius = radius;
            } else {
                throw new IllegalArgumentException("can't be negative");
            }

        }
    }
}
