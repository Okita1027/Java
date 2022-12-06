package class_.包装类;

/**
 * @time 2022/4/28 20:12 星期四
 * String 是 final 类，每次更改值实际上是丢弃原来的字符串对象，之后新建一个对象并把值写入到新对象中，
 * 但String的复用率高，在常量池中只创建一次相同的值，后续有需要直接从常量池中取。
 * 若字符串很少修改，被多个对象引用，就用String
 */
public class String_
{
    public static void main(String[] args)
    {

    }
}
