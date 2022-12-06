package generics;

/**
 * @author 秦智耘
 * @Title 泛型接口
 * @Date 2021年8月19日09:57:46
 */

public class GenericInterface
{
    public static void main(String[] args)
    {
        GenAchieve genAchieve = new GenAchieve();
        System.out.println(genAchieve.next());
    }
}

//泛型接口的类型，在继承接口或实现接口时确定
interface Generator<T>
{
    String language = "java";
    T next();
    default String method()
    {
        return language;
    }
}

//此处继承接口确定泛型的类型
interface GenSon extends Generator<String>
{
    @Override
    String next();
}

//在实现接口时 指定 泛型类型
class GenAchieve implements Generator<String>
{
    @Override
    public String next()
    {
        return method();
    }
}