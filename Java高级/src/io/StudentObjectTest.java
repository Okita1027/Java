package io;

import java.io.*;

public class StudentObjectTest
{
    public static void main(String[] args)
    {
        Student student = new Student("183401", "王同学", "女", "软件技术", 18);
        try
        {
            FileOutputStream fos = new FileOutputStream("C:/test/student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:/test/student.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            student = (Student) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("学号：" + student.num);
            System.out.println("姓名：" + student.name);
            System.out.println("性别：" + student.sex);
            System.out.println("年龄：" + student.age);
            System.out.println("专业：" + student.major);

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}

class Student implements Serializable
{
    String num, name, sex, major;
    int age;

    public Student(String num, String name, String sex, String major, int age)
    {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.age = age;
    }

}
