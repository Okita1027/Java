package collection.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 秦智耘
 * @Title Iterator迭代器
 * @Date 2021/8/12 - 2021年8月12日16:05:32
 */
@SuppressWarnings("all")
public class Iterator_
{
    public static void main(String[] args)
    {
        person p1 = new person("qzy", 18, 175);
        person p2 = new person("hlf", 17, 173);
        person p3 = new person("zk", 18, 172);
        ArrayList arrayList = new ArrayList();
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);

        //迭代器Iterator的好处：
        //使用迭代器Iterator可以使对容器的遍历操作完全与其底层相隔离，达到很好的 解耦 效果。
        Iterator iter = arrayList.iterator();

        //用hasNext方法遍历集合
        //快捷键：itit
        while (iter.hasNext())
        {
            Object next = iter.next();
            System.out.println("next = " + next);
        }

        //此时集合已经遍历完成，若再次使用hasNext()方法,
        //会报错，因为遍历完成之后再次使用hasNext方法会让iterator的游标指向了一个不存在的地方。
        //iter.hasNext  //error
        //如果想再遍历一次，就要让游标指向刚开始的位置
        iter = arrayList.iterator();
        //之后就可以再次使用hasNext进行遍历了。
        while (iter.hasNext())
        {
            Object next = iter.next();
            System.out.println("next = " + next);
        }

    }
}

class person
{
    private final String name;
    private final int age;
    private final double height;

    public person(String name, int age, double height)
    {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}