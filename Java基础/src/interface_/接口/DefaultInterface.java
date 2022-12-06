package interface_.接口;

public interface DefaultInterface {
    //从Java8开始可以在接口中使用默认方法
    //默认方法的调用方式为： 实现类名.方法名
    //默认方法也可以被重写，并且就算不重写默认方法也不报错
    //public 可以省略，但是default不能省略

    default void MethodPrint()
    {
        System.out.println("接口中的默认方法");
    }
}
