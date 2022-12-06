package collection.Map;

import java.util.*;

/**
 * @author 秦智耘
 * @Title Map的6种遍历方式
 * @Date 2021年8月16日08:57:38
 */
public class MapFor
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        Map map = new HashMap();
        map.put(1, "qzy");
        map.put(2, "zk");
        map.put(3, "xfy");

        //第一组：先取出所有key，通过key再取出所有value
        Set keySet = map.keySet();
        System.out.println("=========取出key再取出value （增强for）=========");
        //(1)增强for循环
        for (Object key : keySet)
        {
            System.out.println(key + " - " + map.get(key));
        }
        //(2)迭代器
        System.out.println("=========取出key再取出value （迭代器）=========");
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext())
        {
            Object key =  iterator1.next();
            System.out.println(key + " - " + map.get(key));
        }

        //第二组：把所有value取出
        Collection values = map.values();
        //(1)增强for
        System.out.println("=========取出所有value（增强for）=========");
        for (Object value : values)
        {
            System.out.println(value);
        }
        //(2)迭代器
        System.out.println("=========取出所有value（迭代器）=========");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext())
        {
            Object value =  iterator2.next();
            System.out.println(value);
        }

        //第三组：通过EntrySet来获取key-value
        Set entrySet = map.entrySet();
        //(1)增强for
        System.out.println("=========使用EntrySet（增强for）=========");
        for (Object entry : entrySet)
        {
            //将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //(2)迭代器
        System.out.println("=========使用EntrySet（迭代器）=========");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext())
        {
            Object entry = iterator3.next();
            //向下转型Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }


    }
}
