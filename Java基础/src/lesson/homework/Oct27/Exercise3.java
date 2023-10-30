package lesson.homework.Oct27;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qzy
 * @time 2023/10/30 10:38 星期一
 * @title
 */
public class Exercise3 {
    public static void main(String[] args) {
        HashMap<String, List<Student>> normal = new HashMap<String, List<Student>>();
        HashMap<String, List<Student>> muscle = new HashMap<String, List<Student>>();
        normal.put("普通班", Arrays.asList(new Student(1, "a"), new Student(2, "b"), new Student(3, "c")));
        muscle.put("强化班", Arrays.asList(new Student(11, "aa"), new Student(22, "bb"), new Student(33, "cc")));
        System.out.println("普通班学生信息：");
        for (List<Student> value : normal.values()) {
            for (Student student : value) {
                System.out.println(student);
            }
        }
        System.out.println("强化班学生信息：");
        for (List<Student> value : muscle.values()) {
            for (Student student : value) {
                System.out.println(student);
            }
        }
    }
}
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}