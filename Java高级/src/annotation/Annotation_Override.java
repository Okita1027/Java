package annotation;

/**
 * @author 秦智耘
 * @Date 2021/8/7 - 2021年8月7日13:15:46
 */
public class Annotation_Override
{
    public static void main(String[] args)
    {
        new inter()
        {
            //重写inter接口中的hello方法
            @Override
            public void hello()
            {
                System.out.println("Hello!");
            }
        }.hello();
    }
}

interface inter
{
    void hello();
}