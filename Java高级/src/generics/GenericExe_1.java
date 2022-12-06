package generics;

import java.util.*;

/**
 * @author 秦智耘
 * @Title Generic练习1
 * @Date 2021年8月19日09:49:27
 */
public class GenericExe_1
{
    public static void main(String[] args)
    {
        student s1 = new student("qzy", 18);
        student s2 = new student("zk", 18);
        student s3 = new student("xfy", 18);
        Set<student> hashset = new HashSet<student>(3);
        hashset.add(s1);
        hashset.add(s2);
        hashset.add(s3);
        Iterator<student> iterator = hashset.iterator();
        while (iterator.hasNext())
        {
            student next = iterator.next();
            System.out.println("next = " + next);
        }
//        Map<String, Integer> map = new HashMap<String, Integer>(3);
//        map.put(s1.name, s1.age);
//        map.put(s2.name, s2.age);
//        map.put(s3.name, s3.age);
//        Set<String> strings = map.keySet();
//        for (String key : strings)
//        {
//            System.out.println(key + "-" + map.get(key));
//        }
        HashMap<String, student> map = new HashMap<String, student>();
        map.put("QZY", s1);
        map.put("ZK", s2);
        map.put("XFY", s3);
        Set<Map.Entry<String, student>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, student>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext())
        {
            Map.Entry<String, student> entry = entryIterator.next();
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }
    }
}

class student
{
    String name;
    int age;

    public student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}