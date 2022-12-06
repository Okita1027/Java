package pattern.constructor.prototype;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CitationTest
 * @Description 浅克隆测试类
 * @Date 2022/6/18 21:54 星期六
 */
public class CitationTest01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c1 = new Citation();
        Student stu1 = new Student("张三");
        c1.setStudent(stu1);

        Citation c2 = c1.clone();
        Student stu2 = c2.getStudent();
        stu2.setName("李四");

        System.out.println("stu和stu1是同一个对象？" + (stu2 == stu1));
        c1.show();
        c2.show();
    }
}
