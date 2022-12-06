package generics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 秦智耘
 * @Title 泛型-Generic 与 集合-List 比较
 * @Date 2021年8月18日22:25:25
 */

//@SuppressWarnings({"all"})
public class Generic_List
{
    public static void main(String[] args)
    {
        //集合
        //没有指定泛型，故出现黄色警告
        ArrayList list = new ArrayList();
        //讲dog放入list内会先将dog转成object，再存入；取出时，需要再讲object转成dog，效率低
        list.add(new dog("小黑", 3));
        list.add(new dog("小黄", 2));
        list.add(new dog("小白", 1));
        //list.add(new cat("Tom猫", 5));   //1、集合不能对加入的元素进行约束（不安全）

        Iterator iterator = list.iterator();
        for (Object obj : list)
        {
            dog d = (dog) obj;  //2、在遍历时需要进行向下转型，效率低，而且由于上面添加了不同类型的对象（cat）会导致运行异常
            System.out.println("d = " + d);
        }

        //泛型
        //指定了类型，黄色警告消失
        ArrayList<dog> dogArrayList = new ArrayList<dog>(); //<>中表示该集合只能放dog类型的数据
        dogArrayList.add(new dog("小黄", 3));
        dogArrayList.add(new dog("小黑", 4));
        dogArrayList.add(new dog("小白", 5));
        //dogArrayList.add(new cat("Tom", 5));    //报错，使用泛型后编译时会检查元素类型，提高安全性！
        Iterator<dog> iterator1 = dogArrayList.iterator();
        //原本这里的dog只能写成object，现在就省去了向下转型的步骤，提高了效率
        for (dog d : dogArrayList)
        {
            System.out.println("dog = " + d);
        }
    }
}

class dog
{
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class cat extends animal
{
    private String name;
    private int age;

    public cat(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

class animal{}