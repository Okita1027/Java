package newfeatures;

import java.io.*;

/**
 * @author qzy
 * @time 2023/9/16 17:24 星期六
 * Java9新特性
 * try 的前面可以定义流对象，try 后面的()中可以直接引用流对象的名称。在 try
 * 代码执行完毕后，流对象也可以释放掉，也不用写 finally 了
 *
 * 格式：
 * A a = new A();
 * B b = new B();
 * try(a;b){
 *  可能产生的异常代码
 * }catch(异常类名 变量名){
 *  异常处理的逻辑
 * }
 */
public class TryCatch {
    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) {
            //reader 是 final 的，不可再被赋值
            // reader = null;   //error
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
