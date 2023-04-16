package test.father_pack;

import java.util.Random;

/**
 * @Author qzy
 * @ClassName Father
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/3/14 21:04 星期二
 */
public class Father {
    private int a;
    int c;
    protected int b;
    public int d;

    void method() {
        System.out.println(a);
        final Random random = new Random();
    }
}

