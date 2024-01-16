package classload;

/**
 * @Author qzy
 * @ClassName Test
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/17 16:01 星期六
 */
public class ClassLoadTest {

    static int a = 1;

    static {
        b = 20;
        a = 2;
    }

    static int b = 21;
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }
}
