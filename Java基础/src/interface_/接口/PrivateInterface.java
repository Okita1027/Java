package interface_.接口;

public interface PrivateInterface
{
    //从Java9开始，允许接口中定义私有方法

    default void Hello()
    {
        Method();
    }

    //私有方法即只有此接口中的其他方法才能使用
    private static void Method()
    {
        System.out.println("接口中静态的私有方法");
    }

}
