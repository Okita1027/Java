package collection.Set;

import java.util.*;

/**
 * @author 秦智耘
 * @Title Set接口实现类-HashSet
 * @Date 2021年8月13日19:53:10
 */
public class HashSet_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        * HashSet底层是HashMap,HashMap的底层是（数组+链表+红黑树）
        * 第一次添加时，table数组扩容到16,临界值（threshold）是 16 x 加载因子（loadFactor）是0.75 = 12
        * 若table数组使用到了临界值12，则开始扩容，扩容至目前大小的两倍即 16 x 2 = 32,新的临界值就是32 x 0.75 = 24,后续以此类推
        * 在Java8中,若一条链表的元素个数到达TREEIFY_THRESHOLD（默认为8）,并且table的大小 >= MIN_TREEIFY_CAPACITY（默认为64）,
        * 就会进行树化（红黑树）,否则仍然采用 数组扩容机制
        *
        * 关于添加元素的流程：
        * 1、先获取元素的哈希值（利用hashCode()方法）
        * 2、对哈希值进行运算，得出一个索引值即为要存放在哈希表中的位置
        * 3、如果该位置上没有其它元素，则直接存放
        * 如果已经有其它元素，就用equals进行判断，如果相等，则不添加该元素；如果不等，则以链表的形式添加
        * 注意：
        *   1、hashCode()方法计算出的值 不等同于 最后的哈希值， 调用方法过后还需要进行一次小运算（具体可查看源码）
        *   2、table数组的扩容机制不是只有table数组的长度达到临界值才扩容，而是table数组中所有元素（每个元素都是一个链表）
        *   的所有节点加起来到达临界值就会扩容。
        *   3、equals()方法 判断的不一定是内容，这是可以由 程序员通过重写方法来决定的。
        * */

        Set set = new HashSet();
        set.add("C");
        set.add("Java");
        set.add("C");   //添加失败
        System.out.println("set = " + set);

    }
}
