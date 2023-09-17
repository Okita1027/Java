package newfeatures.Lambda;

import java.util.Random;

/**
 * @time 2022/5/8 16:06 星期日
 */
public class Worker {
    private String name;
    private int age;
    private Double salary;

    public Worker() {
        name = "秦智耘";
        age = 21;
    }

    public Worker(int age) {
        name = "秦智耘";
        this.age = age;
        salary = (double) new Random().nextInt(9999);
    }

    public Worker(String name) {
        this.name = name;
        age = 18;
    }

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
