package pattern.constructor.prototype;

import java.io.*;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CitationTest
 * @Description 浅克隆测试类
 * @Date 2022/6/18 21:54 星期六
 * 要解决引用类型克隆是一个对象的问题，需要使用串行化
 */
public class CitationTest02 {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Citation c1 = new Citation();
        Student stu1 = new Student("张三");
        c1.setStudent(stu1);

        //创建对象输出流对象
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("F:/Java/b.txt"));
        //将c1对象写出到文件中
        oos.writeObject(c1);
        oos.close();

        //创建对象出入流对象
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("F:/Java/b.txt"));
        Citation c2 = (Citation) ois.readObject();
        Student stu2 = c2.getStudent();
        stu2.setName("李四");

        System.out.println("stu和stu1是同一个对象？" + (stu2 == stu1));
        c1.show();
        c2.show();
    }
}
