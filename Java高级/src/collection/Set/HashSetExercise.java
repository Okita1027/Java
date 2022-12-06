package collection.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * @author 秦智耘
 * @Title HashSet练习题
 * @Date 2021年8月15日10:27:41
 */
public class HashSetExercise
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        //练习一：定义employee1类（name、age），在set中添加这个对象，若对象的姓名和年龄在set中有一样的，则不添加
//        Set set = new HashSet();
//        set.add(new employee1("qzy", 18));
//        set.add(new employee1("zk", 18));
//        set.add(new employee1("qzy", 18));

        //练习二：定义employee2类（name、age、date（自定义的date类含year、month、day）），当name 和 date在set 中有重复时，则不添加
        Set set = new HashSet();
        set.add(new employee2("qzy", 18, new employee2.MyDate(2002, 10, 27)));
        set.add(new employee2("zk", 18, new employee2.MyDate(2002, 10, 26)));
        set.add(new employee2("qzy", 0, new employee2.MyDate(2002, 10, 27)));
        System.out.println("set = " + set);
    }
}


//class employee1
//{
//    private String name;
//    private int age;
//
//    public employee1(String name, int age)
//    {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "employee{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    //重写的equals方法和hashcode方法是解决本题的关键
//    //判定当姓名和年龄与表中某对象有重复时，返回内容相等的已存在的对象的相同hash值，得到的hash值一样，则直接不添加该元素
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        employee1 employee = (employee1) o;
//        return age == employee.age && Objects.equals(name, employee.name);
//    }
//
//    @Override
//    public int hashCode()
//    {
//        return Objects.hash(name, age);
//    }
//}

class employee2
{
    private final String name;
    private final int age;
    private final MyDate date;

    public employee2(String name, int age, MyDate date)
    {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    static class MyDate
    {
        private final int year;
        private final int month;
        private final int day;

        @Override
        public String toString()
        {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        public MyDate(int year, int month, int day)
        {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof MyDate)) return false;
            MyDate myDate = (MyDate) o;
            return year == myDate.year && month == myDate.month && day == myDate.day;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(year, month, day);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof employee2)) return false;
        employee2 employee2 = (employee2) o;
        return Objects.equals(name, employee2.name) && Objects.equals(date, employee2.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, date);
    }

    @Override
    public String toString()
    {
        return "employee2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
