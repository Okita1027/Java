package reflection.Class;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @time 2022/5/6 14:34 星期五
 * 反射机制是Java实现动态语言的关键，也就是通过反射实现类动态加载
 * 静态加载：编译时加载相关的类，如果没有则报错，依赖性太强
 * 动态加载：运行时加载需要的类，如果运行时不用该类，即使该类不存在，也不会报错，降低了依赖性
 * 类加载的时间：
 * 1、当创建对象（new）时（静态加载）
 * 2、当子类背加载时，父类也加载（静态加载）
 * 3、调用类中的静态成员时（静态加载）
 * 4、通过反射（动态加载）
 */
public class ClassLoad01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            //person类必须存在，否则直接报错，无法运行
            case 1 -> new person().hello();
            case 2 -> {
                //只有输入2时才会加载Dogd类，即使这个类不存在也没有问题
                Class<?> dog = Class.forName("reflection.Class.Dogd");
                Object o = dog.newInstance();
                Method method = dog.getMethod("method");
                method.invoke(o);
            }
        }
    }
}

class person {
    public void hello() {
        System.out.println("hello");
    }
}