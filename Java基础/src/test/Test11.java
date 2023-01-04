package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author qzy
 * @ClassName Test11
 * @Description 11章
 * @Date 2023/1/3 20:46 星期二
 */
public class Test11 {
    @Test
    public void test01() {
        char ch = 65;
        System.out.println("ch = " + ch);
        System.out.println("(int)ch = " + (int) ch);

        B b = new B();
        b.method2();

        b.method3(new B());
        b.method3(new A());


        System.out.println("==========");
        Object x = new A();
        Object y = new A();
        System.out.println(x.equals(y));
        System.out.println("==========");

        /*
            方法重写在运行时决定执行的方法；
            方法重载在编译时就确定了。
         */
        A q = new A();
        q.f(1);
        A w = new B();
        w.f(2);
    }

    @Test
    public void test02() {
        char c = '\32';
        System.out.println("c = " + c);
        char s = 32;
        System.out.println("s = " + s);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println("list = " + list);
    }

    private class A {
        static int a = 10;
        public int b = 20;

        static void method1() {
            System.out.println("method-A");
        }

        void method2() {
            System.out.println("method-B");
        }

        int c;

        public boolean equals(A a) {
            return a.c == c;
        }

        public void f(int i) {
            System.out.println("Father_F()" + i);
        }
    }

    private class B extends A {
        int b = 40;

        public B() {
            System.out.println("b = " + b);
            System.out.println("super.b = " + super.b);
            super.b = 200;
            System.out.println("b = " + b);
            System.out.println("super.b = " + super.b);

            System.out.println("a = " + a);
        }

        void method3(A a) {
            method2();
        }

        public void f(String s) {
            System.out.println("Son_F()" + s);
        }
    }


    @Test
    public void test03() {
        C c = new C();
        D d = new D();

    }

    class C {
        protected int a;
        int b;
        private int c = 0;
    }

    class D extends C {
        void method() {
        }
    }
}
