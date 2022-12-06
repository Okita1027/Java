package collection.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 秦智耘
 * @Title HashMap
 * @Date 2021年8月16日13:43:56
 */
@SuppressWarnings({"all"})
public class HashMap_
{
    public static void main(String[] args)
    {
        /*
        HashMap出现于1.2
        * 1）HashMap底层维护了Node类型的数组table，默认为null
        * 数组的每个元素都是一个单链表的头结点，其中数据存储的形式是HashMap$Node,
        * 这个Node存储的是<K,V>,而HashMap$Node又实现了Map$Entry接口
        * 2）当创建对象时，将加载因子（loadfactor）默认初始化为0.75
        * 3）当添加key-value时，通过key的哈希值得到在table的索引，然后判断该索引处是否有元素，
        * 如果没有就直接添加（这是最理想的状态），如果该索引处有元素，就判断该元素的key和准备加入的key
        * 是否相等，如果相等，则直接替换val；如果不等，还需要判断是树结构还是链表结构，做出相应的添加方式。
        * 如果添加时发现容量不够，则需要扩容
        * 4）第一次添加时，默认直接把table容量扩到16，临界值（threshold）为12（16 x 0.75）
        * 5）以后需要扩容时，则需要扩容table大小为原来的两倍（16 x 2 = 32），临界值
        * 变为原来的两倍（12 x 2 = 24），以此类推
        * 6）在Java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD(默认为8)，并且
        * table的大小 >= MIN_TREEIFY_CAPACITY(默认为64)，就会进行树化（红黑树）
        * 7)没有实现线程同步，效率比Hashtable高
        * */

        Map map = new HashMap();
        map.put("NO1", "qzy");
        map.put("NO2", "qzy");
        map.put("NO3", "qzy");
        map.put("NO3", "qzy");
        map.put(null, null);
        System.out.println("map = " + map);

    }
}
