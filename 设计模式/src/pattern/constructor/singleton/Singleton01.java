package pattern.constructor.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * @time 2022/4/29 14:40 星期五
 * 单例设计模式：一个类在整个程序中只能实例化一个对象
 * SinglePattern01："饿汉模式"
 * 此模式是事先在类中创建一个私有类对象，将构造方法初始化
 * 想要获取此对象，只能通过类中的静态方法getGriFriend()来获取
 * 这样在整个程序中就算想多new几个GirlFriend对象也会报错
 * 此方法不存在线程安全问题，但如果不使用GirlFriend对象则会造成空间浪费
 * "饿汉模式" 是单例模式中使用最多的
 */
public class Singleton01
{
    public static void main(String[] args)
    {
        GirlFriend griFriend = GirlFriend.getGriFriend();
        System.out.println(griFriend.getName());
    }
}

class GirlFriend implements Serializable//用于Singleton20
{
    private String name;
    private static final GirlFriend girlFriend = new GirlFriend("小红");

    private GirlFriend(String name)
    {
        this.name = name;
    }


    //用于Singleton23（解决反射破坏单例模式）
    private static boolean flag = false;
    private GirlFriend() {
        synchronized (GirlFriend.class) {
            if (flag) {
                throw new RuntimeException("不能创建2次对象！");
            }
            flag = true;
        }
    }


    public static GirlFriend getGriFriend()
    {
        return girlFriend;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //用于singleton22
    //用于在反序列化时自动调用此方法
    @Serial
    public Object readResolve() {
        return GirlFriend.girlFriend;
    }
}