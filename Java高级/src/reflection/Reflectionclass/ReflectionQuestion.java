package reflection.Reflectionclass;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import reflection.Class.CatC;

/**
 * @time 2022/5/4 15:05 星期三
 * 为什么需要反射、基本的使用
 * 优点：可以动态地创建和使用对象，使用灵活，没有反射机制，框架技术就会失去底层支撑
 * 缺点：使用反射基本上是解释执行的，对运行速度有影响
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {
        //传统的方法(new对象.方法)
        //此时我想调用drink方法只能修改源码，将eat改为drink
        CatC cat = new CatC();
        cat.eat();

        //反射的优势通过修改配置文件，而不需要修改源码的情况下控制程序
        FileReader reader = new FileReader("反射\\Reflection\\cat.properties");
        Properties properties = new Properties();
        properties.load(reader);
        String className = properties.getProperty("className");
        System.out.println("className = " + className);
        String methodName = properties.getProperty("methodName");
        System.out.println("method = " + methodName);

        //调用方法
        Class<?> cls = Class.forName(className);
        Object instance = cls.newInstance();
        Method method = cls.getMethod(methodName);
        System.out.println("=====================");
        method.invoke(instance);
        method.setAccessible(true);//关闭访问检查，这样可以微微优化执行速度

        //不能够获得私有字段
//        Field age = cls.getField("name"); //error
        Field ageField = cls.getField("age");
        System.out.println("ageField = " + ageField);
        System.out.println(ageField.get(instance));

        //构造器
        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);


    }
}
