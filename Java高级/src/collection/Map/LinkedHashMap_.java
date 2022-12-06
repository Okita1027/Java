package collection.Map;

import java.util.*;

/**
 * @author 秦智耘
 * @Title LinkedHashMap
 * @Date 2021年8月23日20:53:23
 */
@SuppressWarnings({"all"})
public class LinkedHashMap_
{
    public static void main(String[] args)
    {
        /*
        * LinkedHashMap是HashMap的子类，它在HashMap的基础上，
        * 底层还维护了一个双向链表，这样虽然增大了空间消耗
        * 它的好处在于插入和取出的顺序是一致的
        * */
        Map map = new LinkedHashMap();
        map.put("qzy", 18);
        map.put("sex", "male");
        map.put("height", 175);
        map.put("weight", 65);
        map.put("weight", 66);//替换65
        Set keySet = map.keySet();
        for (Object key : keySet)
        {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("==================");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext())
        {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("==================");
        Set entrySet = map.entrySet();
        for (Object obj : entrySet)
        {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("==================");
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext())
        {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
