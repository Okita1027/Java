package collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Title 实现List接口的三个分支：ArrayList、Vector、LinkedList
 * @author 秦智耘
 * @Date 2021年8月12日10:13:04
 */
@SuppressWarnings("all")
public class List_
{
    public static void main(String[] args)
    {
        /*
        * ArrayList 底层介绍： ArrayList底层是使用一个Object数组实现的
        * 在使用无参构造函数时，每次向集合内添加元素都要判断集合还能不能存放数据（所以说执行效率挺低的），如果不能，就需要扩容
        * 无参构造函数的扩容方式是：第一次扩容增加10个空间，后续的扩容是将目前的空间数x1.5
        * 对于有参构造函数的扩容方式：需要扩容的时候直接按照目前的空间数x1.5
        * 没有实现线程同步

        * Vector：底层也是Object数组，jdk1.0就有，而ArrayList 在1.2才有
        * 扩容方式：无参构造-默认为10，满后x2；有参构造-在空间满后直接按目前2倍空间扩容
        * 实现了线程同步
        * ArrayList 与 Vector相比，它的线程不安全，效率比Vector高

        * LinkedList：底层实现了双向链表、双端队列的特点，所以说它添加/删除元素的效率高，但改查的效率低
        * 它线程不安全，没有实现同步
        * */

        // = 左边是编译类型，右边是执行类型
        // ArrayList、Vector、LinkedList都实现了List接口，所以右边换成Vector、LinkedList都行
        List list = new ArrayList();
        //集合可以添加任意数据类型的变量
        list.add("name");
        list.add(1);
        list.add(true);
        list.add(1, "height");  //向指定位置添加元素
        System.out.println("arrayList1 = " + list);
        //集合中可以添加重复的元素
        list.add("name");

        ArrayList tempList = new ArrayList();
        tempList.add(2);
        tempList.add(4);
        tempList.add(6);
        list.addAll(tempList);
        System.out.println("list2 = " + list);

        //contains:查找指定的元素是否存在
        System.out.println(list.contains("height"));

        //indexOf:返回元素值在集合中的位置下标
        System.out.println(list.indexOf(true));

        //判断是否为空
        System.out.println(list.isEmpty());

        //获得指定索引值下标的元素
        System.out.println(list.get(3));

        //返回集合中元素的个数
        System.out.println(list.size());

        //用指定元素替换集合中指定位置的元素
        list.set(0, "qzyISname");
        System.out.println("list3 = " + list);

        //remove：删除
        list.remove("name");   //按内容
        list.remove(2);     //按下标

        //在遍历集合需要删除元素时注意！
        /*
         在集合内部维护一个字段modCount用于记录集合被修改的次数，每当集合内部结构发生变化(add, remove, set)时，modCount+1。
         在迭代器内部也维护一个字段expectedModCount，同样记录当前集合修改的次数，初始化为集合的modCount值。
         当我们在调用Iterator进行遍历操作时，如果有其他线程修改list会出现modCount!=expectedModCount的情况，就会报并发修改异常java.util.ConcurrentModificationException
         * */
        Iterator iterator = list.iterator();
        boolean flag = true;
        while (iterator.hasNext())
        {
            Object next =  iterator.next();
            if (flag == true)
            {
                iterator.remove();  //安全写法
                //list.remove(next);  //可能会翻车的写法
                flag = false;
                System.out.println("----next---- = " + next);
                System.out.println("--list-- = " + list);
            }
            else
                flag = true;
        }
        System.out.println("list = " + list);

        //清空集合中所有元素
        //list.clear();

    }
}
