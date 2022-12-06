package pattern.constructor.prototype;

import java.io.Serializable;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CitationTest
 * @Description 浅克隆
 * @Date 2022/6/18 21:50 星期六
 */
public class Citation implements Cloneable, Serializable {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "表现良好，特发此证！");
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}

class Student implements Serializable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
