package class_.内部类;

/**
 * @author 秦智耘
 * @date 2021/8/5 - 2021年8月5日09:46:15
 */
/*
什么是局部内部类？
定义在方法中的内部类。
注意：
1、内部类不能被public、private、static修饰；
2、在外部类中不能创建内部类的实例；
3、创建内部类的实例只能在包含他的方法中；
4、内部类访问包含他的方法中的变量必须有final修饰；
5、外部类不能访问局部内部类，只能在方法体中访问局部内部类，且访问必须在内部类定义之后。
*/
public class localityclass
{
    public int x = 1;
    private final int y = 5;
    public void Hello()
    {
        String sex = "male";
        System.out.println("Hello~");
        //局部内部类的class前面不能加修饰符
        class inner
        {
            private final int z = 10;
            public void localMehod()
            {
                //局部内部类能够访问外部类的属性（包括私有）
                System.out.println(x + y + z);
                System.out.println("性别为" + sex);
            }
        }
        //实例化局部内部类只能定义在包含该类的方法中，并且访问只能在这个类定义完之后才行
        inner in = new inner();
        in.localMehod();
    }


    public static void main(String[] args)
    {
        localityclass localityclass = new localityclass();
        localityclass.Hello();
    }
}
