package interface_.接口;

public interface StaticInterface
{
    //接口中的静态方法的调用方法： 接口名.方法名
    static void Method_Print()   //public可以省略
    {
        System.out.println("接口中的静态方法");
    }
}
