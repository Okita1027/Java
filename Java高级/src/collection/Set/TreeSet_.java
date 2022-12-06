package collection.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 秦智耘
 * @Title TreeSet
 * @Date 2021年8月17日16:11:21
 */
public class TreeSet_
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        /*
        * TreeSet底层还是用TreeMap实现的
        * TreeSet在使用无参构造器时仍然是无序的，
        * 需要使用另一个构造器（传入一个 比较器（匿名内部类）），并指定排序规则
        * TreeSet中的元素就会按照比较器的规则变成有序的集合
        * */
        Set set = new TreeSet();
        set.add("qzy");
        set.add("zk");
        set.add("wasd");
        set.add("p");
        set.add("p");//无效
        System.out.println("set = " + set);

        /*
        * TreeSet去重机制：如果在实例化时传入了一个Comparator匿名对象，
        * 就使用实现的compare方法去重（若方法返回0，则认为是相同的数据，不添加）
        * 如果实例化时不传入这个Comparator匿名对象，则以你添加的对象实现Compareable接口的compareTo去重
        * */
        //person类没有实现Comparable接口，根据源码person无法转成Comparable类型与自己比较，所以会报错
        //set.add(new person("123"));  //运行异常

        TreeSet treeSet = new TreeSet(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                //1、这里调用String的compare方法以两个字符串的大小作为排序规则
                //return ((String)o1).compareTo((String)o2);
                //2、这里调用String的length方法以两个字符串的长度作为排序规则
                return ((String)o1).length()-((String)o2).length();
            }
        });
        treeSet.add("a");
        treeSet.add("pq");
        treeSet.add("xyz");
        treeSet.add("wasd");
        System.out.println("treeSet = " + treeSet);
    }
}
class person //implements Comparable
{
//    @Override
//    public int compareTo(Object o)
//    {
//        return 0;
//    }

    private final String name;

    public person(String name)
    {
        this.name = name;
    }
}