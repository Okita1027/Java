package collection.Map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author 秦智耘
 * @Title HashTable
 * @Date 2021年8月17日14:57:01
 */
public class HashTable_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        Hashtable出现于1.0
        * 1、底层是用Hashtable$Entry[]数组实现的，初始化大小为11
        * 2、临界值threshold 为 8 （11 x 0.75）
        * 3、扩容机制：当元素数量大于等于临界值时进行扩容
        *   if (count >= threshold)
        *   扩容后的大小为 原来的2倍+1
        *   int newCapacity = (oldCapacity << 1) + 1;即 11 x 2 + 1 = 23
        * 4、线程安全，相比HashMap效率低
        * */
        Map map = new Hashtable();
        map.put("qzy", 18);
        map.put("zk", 18);
        map.put("zmy", 18);
        map.put("zmy", 20);
        map.put(1, 20);
        map.put(2, 20);
        map.put(3, 20);
        map.put(4, 20);
        map.put(5, 20);
        map.put(6, 20);
        map.put(7, 20);
        map.put(8, 20);
        System.out.println("map = " + map);
    }
}
