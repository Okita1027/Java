package reflection.Class;

/**
 * @time 2022/5/4 17:57 星期三
 */
public class CatC {

    public String name;
    public int age = 10;
    public String color;

    public CatC() {
        name = "大橘";
        color = "白色";
    }

    public CatC(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("吃吃吃！");
    }

    public void drink() {
        System.out.println("喝喝喝！");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}