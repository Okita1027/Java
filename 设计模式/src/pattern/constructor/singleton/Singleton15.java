package pattern.constructor.singleton;

/**
 * @Date 2022/6/17 21:06 星期五
 * 饿汉式：使用枚举类实现
 * Enum是JVM底层实现，已经将所有问题解决了
 * 由于枚举类只会被加载一次，并且不存在线程安全问题，也不会被破坏
 * 所以枚举类最适合用于单例设计模式，在不考虑内存浪费时首选
 * ！！！极力推荐！！！
 */
public class Singleton15 {
    public static void main(String[] args) {
        Mather m1 = Mather.INSTANCE;
        Mather m2 = Mather.INSTANCE;
        System.out.println(m1 == m2);//true

        Mather instance2 = Mather.INSTANCE2;
        System.out.println(instance2 == m1);//false

        instance2.setId(2);
        System.out.println("instance2.getId() = " + instance2.getId());

    }
}

enum Mather {
    INSTANCE, INSTANCE2(1, "有参构造");
    private Integer id;
    private String name;

    Mather() {
    }

    Mather(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}