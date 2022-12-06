package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秦智耘
 * @Title 泛型的使用
 * @Date 2021年8月19日09:44:46
 */
public class GenericUse
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        //Generic类 在Generic_3.java中，animal、cat、dog在Generic_1.java

        //泛型的类型参数只能是类 类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> IntegerGeneric = new Generic<Integer>(123456);
        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> StringGeneric = new Generic<String>("key_value");
        /*细节：左边<>中写了类型，编译器会自动进行类型推断，知道你右边也是这个类型
         *所以右边<>中可以省略不写，这也是推荐的写法
         *Generic<String> StringGeneric = new Generic<>("key_value");
        */

        //之前写集合时虽然没有指定泛型，这实际上这样也有泛型的效果，不过它的默认泛型是Object类型
        List list = new ArrayList();    //等价于List<Object> list = new ArrayList<Object>();
        //比如list.add方法
        //这个时候括号内提示你传入Object类型数据
        //但如果你在创建对象时指定了泛型，add方法括号内又会提示你输入指定的泛型类型数据
        //list.add(123);
        System.out.println("泛型测试,key is " + IntegerGeneric.getKey());
        System.out.println("泛型测试,key is " + StringGeneric.getKey());

        //不能对确切的泛型类型使用instanceof操作，下面的操作是非法的，编译时会报错
        Number n;
        //if(Number instanceof Generic<Number>){}

        //Generic<dog> dogGeneric = new Generic<dog>(new cat("white", 1));  //因为泛型指定了dog，所以传入cat会报错
        //在给泛型指定具体类型后，可以传入该类型或是它的子类型
        ArrayList<animal> arrayList = new ArrayList<>();
        //cat继承了animal类，所以可加入
        arrayList.add(new cat("white", 12));
    }
}
