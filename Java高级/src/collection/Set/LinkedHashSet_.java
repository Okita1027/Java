package collection.Set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 秦智耘
 * @Title LinkedHashSet
 * @Date 2021年8月15日13:30:32
 */
public class LinkedHashSet_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        * LinkedHashSet是HashSet的子类，其底层是用hash表和双向链表实现的
        * 在添加一个元素时，先求hash值，再求索引，确定该元素在hashtable中的位置，然后将添加的元素加入双向链表
        * 若数据已存在，则不添加（原则和HashSet一样）
        * 由于是用双向链表实现的，所以插入和取出的顺序是一样的
        * 添加第一次时，直接将数组table扩容到16，存放的结点类型是 LinkedHashMap$Entry
        * 数组是HashMap$Node[] 存放的数据类型是 LinkedHashMap$Entry
        * */
        Set set = new LinkedHashSet();
        set.add("C");
        set.add("Java");
        set.add("C");   //添加失败
        System.out.println("set = " + set);
    }
}
