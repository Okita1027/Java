package test.oop;

/**
 * @Author qzy
 * @ClassName Outer
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/29 22:46 星期日
 */
public class Outer {
    private String name;
    private int i;

    public Outer() {
        name = "Outer";
        i = 20;
    }

    void print() {
        final Inner inner = new Inner();
        inner.printInfo();
    }

    class Inner {
        private String name;
        private int i;

        public Inner() {
            name = "Inner";
            i = 10;
        }

        void printInfo() {
            System.out.println("外：" + Outer.this.name + Outer.this.i);
            System.out.println("内：" + name + i);
        }
    }
}
