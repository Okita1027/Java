package class_.内部类;

public class outerclass
{
    private static final int age = 18;
    public double height = 175;
    private final int num = 10;
    private void Method()
    {
        System.out.println("Method:Hello~");
        //在外部类的非静态方法中，因为有隐含的外部类引用this，所以可以直接创建非静态内部类。
        innerclass c1 = new innerclass();
        System.out.println(c1.sex);
    }
    private static void NiHao()
    {
        System.out.println("你好！");
        //在外部类的静态方法中，因为没有this，所以必须先获得外部类引用，然后创建非静态内部类。
        innerclass c2 = new outerclass().new innerclass();
        System.out.println(c2.sex);
    }

    class innerclass
    {
        //private static String name = "qzy"; //error,成员内部类中不能存在静态属性
        private final int sex = 1;
        void Hello()
        {
            System.out.println(height);
            //内部类能够访问外部类的私有属性（变量）
            System.out.println(num);
            System.out.println(age);
            //内部类能够访问外部类的私有属性（方法）
            Method();
        }
    }

    //静态内部类
    static class innerclass2
    {
        private final String Gendar = "male";
        private void showmale()
        {
            System.out.println(Gendar);
            System.out.println(age);    //true,静态内部类只能访问同为静态的外部类属性
            NiHao();

            //System.out.println(num);  //error,静态内部类不能直接访问外部类的非静态属性
            //Mehod();

        }
    }

    public static void main(String[] args)
    {

        outerclass out = new outerclass();
        out.Method();
        //成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
        //innerclass innerclass = new innerclass();     //error,不能直接实例化内部类
        outerclass.innerclass innerclass = out.new innerclass();  //true,非静态内部类，必须有一个外部类的引用才能创建

        innerclass2 innerclass2 = new innerclass2();    //静态内部类不需要引用，可以直接创建
    }
    //非静态内部类之所以可以直接访问外部类的方法，是因为创建非静态内部类时，有一个隐含的外部类引用被传递进来。
}
