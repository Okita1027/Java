package pattern.constructor.singleton;

/**
 * @Date 2022/6/17 20:14 星期五
 * 饿汉式2：使用静态代码块，与方式1一样仍然会浪费资源
 */
public class Singleton02 {
    public static void main(String[] args) {
        BoyFriend b1 = BoyFriend.newInstance();
        BoyFriend b2 = BoyFriend.newInstance();
        System.out.println(b2 == b1);
    }
}

class BoyFriend {
    private String name;
    private Integer age;
    private static BoyFriend boyFriend;
    private BoyFriend() {

    }

    static {
        boyFriend = new BoyFriend();
    }

    public static BoyFriend newInstance() {
        return boyFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}