package pattern.constructor.singleton;

/**
 * @Date 2022/6/17 20:51 星期五
 * SinglePattern10：使用静态内部类来实现
 * 在没有加任何锁的情况下，保证了线程安全，并且不会影响性能和空间的浪费
 * 推荐使用此方式
 */
public class Singleton10 {
    public static void main(String[] args) {
        Father f1 = Father.newInstance();
        Father f2 = Father.newInstance();
        System.out.println(f1 == f2);
    }
}

class Father {
    private String name;
    private Integer age;

    private Father() {
    }

    //第一次加载Father类不会初始化INSTANCE
    private static class fatherInternal {
        private static final Father INSTANCE = new Father();
    }

    //只有调用此方法时，才会加载INSTANCE
    public static Father newInstance() {
        return fatherInternal.INSTANCE;
    }
}