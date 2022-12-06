package class_.内部类;

/**
 * @author 秦智耘
 * @date 2021/8/5 - 2021年8月5日10:06:10
 */
public class anonymousclass
{
    String name = "qzy";
    public void printname()
    {
        System.out.println(name);
    }

    public static void main(String[] args)
    {
        new anonymousclass().printname();

        //本身接口是不能new的，但是这样写相当于是new了一个匿名对象实现了这个inter接口
        new inter()
        {
            @Override
            public void Mehod()
            {
                System.out.println("接口的匿名new实现");
            }
        }.Mehod();
    }
}
