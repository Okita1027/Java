package newfeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author qzy
 * @time 2023/9/16 17:29 星期六
 * JDK 10 的新特性
 * 局部变量的显示类型声明，常常被认为是不必须的，给一个好听的名字反而可以很清楚的表达出下面应该怎样继续。
 * 本新特性允许开发人员省略通常不必要的局部变量类型声明，以增强 Java 语言的体验性、可读性。
 *
 * 不适用场景
 * – 声明一个成员变量
 * – 声明一个数组变量，并为数组静态初始化（省略 new 的情况下）
 * – 方法的返回值类型
 * – 方法的参数类型
 * – 没有初始化的方法内的局部变量声明
 * – 作为 catch 块中异常类型
 * – Lambda 表达式中函数式接口的类型
 * – 方法引用中函数式接口的类型
 */
public class Var {
    public static void main(String[] args) {
        //1.局部变量的实例化
        var list = new ArrayList<String>();
        var set = new LinkedHashSet<Integer>();
        //2.增强 for 循环中的索引
        for (var v : list) {
            System.out.println(v);
        }
        //3.传统 for 循环中
        for (var i = 0; i < 100; i++) {
            System.out.println(i);
        }
        //4. 返回值类型含复杂泛型结构
        var iterator = set.iterator();
        //Iterator<Map.Entry<Integer, Student>> iterator = set.iterator();
    }
}
