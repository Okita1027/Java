package test;

/**
 * @Author qzy
 * @ClassName Exam
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/2/4 22:09 星期六
 */
public class Exam {
    public static void main(String[] args) {
        /*A a = new B();
        System.out.println(a.a);
        a.print();
        final A a1 = new A();
        a1.print();
        final B b = new B();
        b.print();*/

        int a, b;
        a = b = 1;
        float c, d;
        c = d = 1.1f;
        char ch = 'a';
        switch (ch + 2) {
            case 'b':
                System.out.println("b");
                break;
            case 'c':
                System.out.println(c);
                break;
            default:
                System.out.println("default");
        }


        int i = 1;
        while (i < 10) {
            if ((i++) % 2 == 0) {
                System.out.print(i);//3579
            }
        }

    }

}

class A {
    int a = 1;

    public A() {
        System.out.println("A");
    }

    void print() {
        System.out.println(a);
    }

}

class B extends A {
    int a = 2;

    public B() {
        System.out.println("B");
    }

    @Override
    void print() {
        System.out.println(a);
    }

}