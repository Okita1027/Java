package generics;

import java.util.*;

/**
 * @author 秦智耘
 * @Title 泛型练习2
 * @Date 2021年8月19日14:43:14
 */
public class GenericExe_2
{
    public static void main(String[] args)
    {
        employee e = new employee();
        employee qzy = new employee("a", 100000, e.new MyDate(10, 26, 2003));
        employee zk = new employee("a", 100000, e.new MyDate(10, 26, 2002));
        employee lzc = new employee("a", 100000, e.new MyDate(8, 18, 2003));
        employee qq = new employee("a", 100000, e.new MyDate(10, 22, 2002));
        employee pp = new employee("a", 100000, e.new MyDate(1, 18, 2002));
        List<employee> list = new ArrayList<>();
        list.add(qzy);
        list.add(zk);
        list.add(lzc);
        list.add(qq);
        list.add(pp);
        System.out.println("list = " + list);
        list.sort(new Comparator<employee>()
        {
            @Override
            public int compare(employee o1, employee o2)
            {
                //先按name排序，若name相同，则按birthday排序，即定制排序
                //先对传入的参数进行验证
                if(!(o1 instanceof employee && o2 instanceof employee))
                {
                    System.out.println("类型错误！");
                    return 0;
                }
                //比较name就写在这儿
                int flag = o1.getName().compareTo(o2.getName());
                if (flag != 0)
                    return flag;
                //比较birthday-1
                //return o1.getMyDate().toString().compareTo(o2.getMyDate().toString());
                //比较birthday-2，这段代码太长，可以将其封装至MyDate类中的Compare方法
                //int com = o1.getMyDate().getYear() - o2.getMyDate().getYear();
                // if (com != 0)
                //     return com;
                // com = o1.getMyDate().getMonth() - o2.getMyDate().getMonth();
                // if (com != 0)
                //     return com;
                // com = o1.getMyDate().getDay() - o2.getMyDate().getDay();
                // if (com != 0)
                //     return com;
                // return 0;

                //现在重写完成了，原本写在本方法里的代码可以直接调用在MyDate中 重写好的 CompareTo的方法了
                return o1.getMyDate().compareTo(o2.getMyDate());
            }
        });
        System.out.println("========================================");
        System.out.println(list);


    }
}

class employee
{
    public employee()
    {
    }

    private String name;
    private int sal;
    private MyDate myDate;

    public employee(String name, int sal, MyDate myDate)
    {
        this.name = name;
        this.sal = sal;
        this.myDate = myDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSal()
    {
        return sal;
    }

    public void setSal(int sal)
    {
        this.sal = sal;
    }

    public MyDate getMyDate()
    {
        return myDate;
    }

    public void setMyDate(MyDate myDate)
    {
        this.myDate = myDate;
    }

    @Override
    public String toString()
    {
        return "\nemployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", myDate=" + myDate +
                '}';
    }

    //要把比较birthday的代码通过重写Compare方法封装在这个类中，首先要实现Comparator接口
    class MyDate implements Comparable<MyDate>  //这里一定要指定泛型，能将重写方法时的形参改成MyDate
    {
        private int month, day, year;
        public MyDate(int month, int day, int year)
        {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int getMonth()
        {
            return month;
        }

        public void setMonth(int month)
        {
            this.month = month;
        }

        public int getDay()
        {
            return day;
        }

        public void setDay(int day)
        {
            this.day = day;
        }

        public int getYear()
        {
            return year;
        }

        public void setYear(int year)
        {
            this.year = year;
        }

        @Override
        public String toString()
        {
            return "MyDate{" +
                    "month=" + month +
                    ", day=" + day +
                    ", year=" + year +
                    '}';
        }

        @Override
        public int compareTo(MyDate o)
        {
            int flag = this.year - o.getYear(); //this可以不写，因为指向的是本类的属性
            if (flag != 0)
                return flag;

            flag = month - o.getMonth();
            if (flag != 0)
                return flag;

                return day - o.getDay();
        }
    }
}
