package collection.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 秦智耘
 * @Title Map介绍
 * @Date 2021年8月15日20:27:39
 */
public class Map_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        * Map用于保存具有映射关系的数据：Key-Value（双列元素）
        * 之前的HashSet虽然也是Key-Value的形式，但它的Value是用常量Present填充的，只使用了Key
        * Map中的key 和 value 可以是任何引用类型的数据，会封装到HashMap$Node 对象中
        * Map中的key不允许重复，原因和HashSet一样，但是value可以有重复
        * Map底层也是用table数组和hashcode实现的，所以输入和输出的顺序不同。
        * 注意：
        *   key通常用String类充当，但实际上其它类型也可以充当key
        *   key - value 是一对一的关系，通过key一定能找到对应的value
        * */
        //HashMap底层是（数组+链表+红黑树）
        //HashMap没有实现同步，因此是线程不安全的方法上没有做互斥同步的操作（方法上没有synchronized）
        Map map = new HashMap();
        map.put("NO1", "C");
        map.put("NO2", "Java");
        map.put("NO3", "Python");
        map.put("NO1", "C++");  //有相同的key，就替换之前的内容
        map.put(null, "null");
        map.put(null, "C#");    //替换null
        map.put("NO4", "C");

        System.out.println("map = " + map);

        /*
        * 1、Key - Value 数据形式是 HashMap$Node node = newNode(hash, key, value, null);
        * 2、k - v 为了方便程序员遍历，还创建了EntrySet集合，该集合存放的元素类型为Entry，而一个Entry
        * 对象就有k, v EntrySet<Entry<K,V>>即：transient Set<Map.Entry<K,V>> entrySet;
        * 3、entrySet中，定义的类型是Map.Entry，但是实际上存放的还是HashMap$Node
        * 这是因为static class Node<K,V> implements Map.Entry<K,V>
        * 4、当把HashMap$Node对象存放到entrySet就方便遍历，因为Map.Entry提供了重要的方法
        * K getKey(); V getValue();
        * */
        Set set = map.entrySet();
        System.out.println(set.getClass()); //HashMap$EntrySet

        for (Object obj : set)
        {
            //System.out.println(obj.getClass()); //HashMap$Node
            //为了从HashMap$Node 取出k-v
            //1、先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        //常用方法
        //remove:根据键删除映射关系
        map.remove(null);
        System.out.println("map = " + map);
        //get:根据键获取值
        System.out.println(map.get("NO1"));
        //size:获取元素个数
        System.out.println(map.size());
        //isempty:判定是否为空
        System.out.println(map.isEmpty());
        //clear:清空所有元素
        //System.out.println("map = " + map);
        //containsKey:查找键是否存在
        System.out.println(map.containsKey("NO2"));
        //containsValue:查找值是否存在
        System.out.println(map.containsValue("Java"));

    }
}
