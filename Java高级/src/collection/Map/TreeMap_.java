package collection.Map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 秦智耘
 * @Title TreeMap
 * @Date 2021年8月18日20:38:10
 */
public class TreeMap_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        //TreeMap的资料写在TreeSet里了
        TreeMap treeMap = new TreeMap();
        treeMap.put("key", "value");
        treeMap.put("qzy", 18);
        treeMap.put("jh", 18);
        treeMap.put("yck", 49);
        System.out.println("treeMap = " + treeMap);

        TreeMap treeMap1 = new TreeMap(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return ((String)o1).compareTo((String) o2);
            }
        });
        treeMap1.put("aaa", "value");
        treeMap1.put("ccc", "value");
        treeMap1.put("bbb", "value");
        treeMap1.put("bbb", "value");//添加失败，遇到相同的元素直接取消添加（并不是覆盖原来的值）
        System.out.println("treeMap1 = " + treeMap1);
    }
}
