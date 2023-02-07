package test.oop;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author qzy
 * @ClassName Course
 * @Description 课程信息类
 * @Date 2023/2/6 22:53 星期一
 */
public class Course {
    public static void main(String[] args) {
        final Course math = new Course("Math");
        math.addStudents("asd", "ds");
    }

    private String courseName;
    private ArrayList<String> studentNameList;
    private int studentNum;

    public Course(String courseName) {
        this.courseName = courseName;
        studentNameList = new ArrayList<>();
    }

    public void addStudents(String... studentName) {
        studentNameList.addAll(Arrays.asList(studentName));
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<String> getStudentNameList() {
        return studentNameList;
    }

    public int getStudentNum() {
        return studentNum;
    }
}
