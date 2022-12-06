package reflection.Class;

/**
 * @time 2022/5/4 17:58 星期三
 */
public class Dogd {
    public String name;
    public Dogd() {
        this.name = "小黑";
    }
    public Dogd(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println("狗的名字是：" + name);
    }
}
