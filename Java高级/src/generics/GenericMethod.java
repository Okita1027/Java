package generics;

/**
 * @author 秦智耘
 * @Title 泛型方法
 * @Date 2021年8月19日21:24:25
 */
public class GenericMethod
{
    public static void main(String[] args)
    {
        Car car = new Car();
        //此处括号内提示你传入的是Object类型
        //泛型使用的都是包装类，这里编译器会自动对数据进行装箱操作（见输出效果）
        car.fly( "宝马", 1000);
        car.fly( 555.0, "hhh");

        Fish<String, String> stringStringFish = new Fish<>();
        stringStringFish.eat("猫", "cat");
        stringStringFish.attack("猛鱼甩尾", "鱼越龙门");
    }

}

class Car
{
    public void run(){}
    //泛型方法，可以定义在普通类中
    public <K, V> void fly(K k, V v)
    {
        System.out.println(k.getClass());
        System.out.println(v.getClass());
    }
}

class Fish<B, P>
{
    public void swim(){}
    //泛型方法，也可以定义在泛型类中
    public <K, V> void eat(K k, V v)
    {
        System.out.println("k = " + k);
        System.out.println("v = " + v);
    }

    //这个attack不算 泛型方法，因为它没有在返回值类型前声明泛型
    //这种只能算是 方法有用到泛型
    public void attack(B b, P p)
    {
        System.out.print("Fish Attack：");
        System.out.println("泛型b = " + b);
        System.out.println("泛型p = " + p);
    }
}