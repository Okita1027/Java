package pattern.constructor.singleton;

/**
 * @time 2022/4/29 14:40 星期五
 * 单例设计模式：一个类在整个程序中只能实例化一个对象
 * SinglePattern05："懒汉模式"
 *
 * 此方法不会造成空间浪费，但有线程安全问题
 */
public class Singleton05
{
    public static void main(String[] args)
    {
        Wife wife = Wife.getWife("小华");
        Wife wife1 = Wife.getWife("小花");
        System.out.println(wife == wife1);
    }
}

class Wife
{
    private String name;
    private static Wife wife;
    private Wife(String name)
    {
        this.name = name;
    }

    //懒汉式的问题：线程不安全
    //解决方法是为此方法添加synchronized关键字
    public static Wife getWife(String name)
    {
        //如果还没有创建过Wife对象，就new一个新的
        if (wife == null)
        {
            Wife wife = new Wife(name);
        }
        //否则就返回之前创建了的静态的wife
        return wife;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}