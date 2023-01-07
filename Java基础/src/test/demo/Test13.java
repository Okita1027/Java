package test.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author qzy
 * @ClassName Test13
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/6 19:09 星期五
 */
public class Test13 {
    class A implements Cloneable {
        B b;
        C c;
        public A() {
            b = new B();
            c = new C();
        }
        @Override
        protected A clone() throws CloneNotSupportedException {
            A clone = (A) super.clone();
            clone.b = b.clone();
            return clone;
        }
    }

    class B implements Cloneable {
        @Override
        protected B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    class C {

    }

    @Test
    void test01() throws CloneNotSupportedException {
        A a = new A();
        A clone = a.clone();
        System.out.println(a == clone);//false
        System.out.println(a.b == clone.b);//false
        System.out.println(a.c == clone.c);//true
    }


}
