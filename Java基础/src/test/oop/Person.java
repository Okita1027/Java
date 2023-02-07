package test.oop;

/**
 * @Author qzy
 * @ClassName Person
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/1/29 22:21 星期日
 */
public abstract class Person {
    protected String name;
    protected Character sex;
    protected int age;

    public Person(String name, Character sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    protected abstract void showInfo();
}
class Student extends Person {
    private String school;
    private int grade;

    public Student(String name, Character sex, int age, String school, int grade) {
        super(name, sex, age);
        this.school = school;
        this.grade = grade;
    }

    @Override
    protected void showInfo() {
        System.out.println("信息为：" + name + sex + age + school + grade);
    }
}