package generics;

/**
 * @author 秦智耘
 * @Title 自定义泛型
 * @Date 2021年8月19日15:56:44
 */
public class GenericCustom
{
    public static void main(String[] args)
    {
        /*
        * 自定义泛型需要注意的事项：
        * 普通成员可以使用泛型（属性、方法）
        * 使用泛型的数组，不能初始化
        * 静态方法中不能使用类的泛型
        * 泛型类的类型，是在创建对象时确定（因为创建对象时，需要指定确定的类型）
        * 如果在创建对象时，没有指定泛型类型，则默认为Object
        * */
    }
}

//自定义泛型
//T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
class Generic<T>    //泛型的标识符可以有多个
{
    //key这个成员变量类型为T，T的类型由外部指定
    private final T key;  //普通成员可以使用泛型

    T[] ta; //泛型类型数组可以定义
    //但是不能初始化，因为现在无法确定T的类型，也就不能够开辟空间
    //ta = new T[5];//会报错
    //泛型构造方法形参key的类型也为T，T的类型由外部指定
    public Generic(T key)   //一般方法可以使用泛型
    {
        this.key = key;
    }

    //泛型属性和方法都不能用static修饰
    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM在不知道实际类型的情况下，无法开辟空间
//    private static T value;
//    public static void hello(T t)
//    {
//        System.out.println("hello");
//    }

    //泛型方法getKey的返回值类型为T，T的类型由外部指定
    public T getKey()
    {
        return key;
    }

    //此方法用于GenericWildcard
    public void showKeyValue1(Generic<?> obj)   //类型通配符一般是使用?。?是类型实参，不是类型形参！
    {
        System.out.println("泛型测试，key value is" + obj.getKey());
    }

}
