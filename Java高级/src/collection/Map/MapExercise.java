package collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 秦智耘
 * @Title Map练习
 * @Date 2021年8月16日10:03:33
 */
public class MapExercise
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        //使用hashmap添加三个员工对象，遍历显示工资>15000的员工
        Map map = new HashMap();
        map.put(001, new employee("qzy", 10000, 001));
        map.put(002, new employee("hlf", 20000, 002));
        map.put(003, new employee("zmy", 30000, 003));

        //增强for
        Set keySet = map.keySet();
        for (Object key : keySet)
        {
            //map.get(key)得到的是类是Map.employee,将其强转成employee赋给emp
            employee emp = (employee) map.get(key);
            //再通过emp.getSal()判断工资是否大于15000,大于则输出
            if(emp.getSal() > 15000)
                System.out.println(key  + "-" + map.get(key));
                                            //  map.get(key)可以换成emp
        }

        //迭代器
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext())
        {
            Object entry =  iterator.next();
            Map.Entry e = (Map.Entry) entry;
            employee emp = (employee) e.getValue();
            if(emp.getSal() > 15000)
                System.out.println(e.getKey() + "-" + e.getValue());
        }


    }
}

class employee
{
    private String name;
    private double sal;
    private int ID;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSal()
    {
        return sal;
    }

    public void setSal(double sal)
    {
        this.sal = sal;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }


    public employee(String name, double sal, int ID)
    {
        this.name = name;
        this.sal = sal;
        this.ID = ID;
    }

    @Override
    public String toString()
    {
        return "employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", ID=" + ID +
                '}';
    }
}