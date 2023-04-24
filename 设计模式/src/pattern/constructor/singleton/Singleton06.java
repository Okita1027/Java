package pattern.constructor.singleton;

/**
 * @time 2022/4/29 14:40 星期五
 * 单例设计模式：一个类在整个程序中只能实例化一个对象
 * SinglePattern06："懒汉模式"
 *
 * 此方法解决了线程安全问题，并且提高了效率
 * 推荐使用此方式
 */
public class Singleton06
{
    public static void main(String[] args)
    {
        Wife2 wife = Wife2.getWife("小华");
        Wife2 wife1 = Wife2.getWife("小花");
        System.out.println(wife == wife1);
    }
}

class Wife2
{
    private String name;
    //添加volatile关键字（涉及并发编程的知识），能进一步提高效率
    private static volatile Wife2 wife2;
    private Wife2(String name)
    {
        this.name = name;
    }

    //线程同步实现多线程安全
    public static synchronized Wife2 getWife(String name)
    {
        if (wife2 == null) {
            //只需要在写操作前实现线程同步，提高效率
            synchronized (Wife2.class) {
                //抢到锁之后再次判断是否为空
                if (wife2 == null) {
                    //实例化称为写操作
                    wife2 = new Wife2(name);
                }
            }
        }
        //取值称为读操作
        return wife2;
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