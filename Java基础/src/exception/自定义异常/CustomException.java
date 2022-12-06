package exception.自定义异常;

import java.util.Scanner;

/**
 * @author 秦智耘
 * @date 2021/8/6 - 2021年8月6日13:31:21
 */
public class CustomException
{
    public static void main(String[] args) /*throws AgeException*/
    {
        System.out.println("请输入年龄（18 - 24）：");
        int age = new Scanner(System.in).nextInt();
        if (age >= 18 && age <= 24)
            System.out.println("数据符合要求！");
        else
            throw new AgeException("输入的年龄不符合要求！");

    }
}

//自定义异常通常 继承 RuntimeException 而不是 Exception
//原因是前者用起来方便，若继承后者，还需要把主函数注释部分给去掉
class AgeException extends RuntimeException
{
    public AgeException(String message)
    {
        super(message);
    }
}
