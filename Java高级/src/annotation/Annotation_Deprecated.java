package annotation;

/**
 * @author 秦智耘
 * @Date 2021/8/7 - 2021年8月7日13:24:58
 */
public class Annotation_Deprecated
{
    public static void main(String[] args)
    {
        A a = new A();
        a.hello();
    }
}

class A
{
    int age = 18;
    @Deprecated
    void hello()
    {
        System.out.println("Hello, Age:" + age);
    }
}