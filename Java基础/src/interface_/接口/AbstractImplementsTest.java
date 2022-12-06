package interface_.接口;

public class AbstractImplementsTest implements AbstractImplements
{

    public static void main(String[] args)
    {
        //正常用法
        AbstractImplementsTest abs = new AbstractImplementsTest();
        abs.PrintHello();

        //匿名内部类 用法
        AbstractImplements obj = new AbstractImplements()
        {
            @Override
            public void PrintHello()
            {
                System.out.println("匿名内部类");
            }
        };
        obj.PrintHello();

        //匿名内部类而且省略了对象名称所以也是匿名对象
        new AbstractImplements()
        {
            @Override
            public void PrintHello()
            {
                System.out.println("匿名内部类&匿名对象");
            }
        }.PrintHello();
    }

    @Override
    public void PrintHello()
    {
        System.out.println("重写接口中的抽象方法");
    }

}
