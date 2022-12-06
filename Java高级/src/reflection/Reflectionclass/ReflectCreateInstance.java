package reflection.Reflectionclass;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @time 2022/5/7 10:46 星期六
 * 反射——爆破创建实例、操作属性、方法
 * 在这个程序中，Bird类的字段、方法都写成了private，在实际开发中，private所对应的封装性就提示你不要来调用这些私有的字段
 * 而反射又能通过爆破强行获取私有字段、方法，例如在单例设计模式中，类中构造器私有化了并且定义了对象，
 * 暗示要想用这个对象实例，建议就调用对应的public方法就行了。如果强行通过反射来实例化，就违背了原本的设计模式。
 * 封装表达的是建议怎么做，反射则是能不能这么做。
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileReader("反射\\Reflection\\bird.properties"));
        Object className = properties.get("className");
        Class<?> dogClass = Class.forName(className.toString());

        //创建实例
        //Declared：获得包括私有的所有构造器/字段/方法
        Constructor<?> constructor = dogClass.getDeclaredConstructor(String.class, String.class, int.class);
        constructor.setAccessible(true);//因为构造器私有，必须使用爆破
        Object o = constructor.newInstance("鹦鹉", "YinWu", 3);

        //访问属性
        String fieldName = properties.getProperty("fieldName");
        Field color = dogClass.getDeclaredField(fieldName);
        color.setAccessible(true);
        color.set(o, "彩色");
        System.out.println(color.get(o));

        //调用方法
        Method method = dogClass.getDeclaredMethod("method");
        method.setAccessible(true);//因为方法私有，必须使用爆破
        method.invoke(o);

        String methodName = properties.getProperty("methodName");
        String[] methods = methodName.split(",");
        method = dogClass.getDeclaredMethod(methods[1]);
        System.out.println(method.invoke(o));
    }
}

class Bird {
    private String brand, name;
    private int age;
    private static String color;

    private Bird(String brand, String name, int age){
        this.brand = brand;
        this.name = name;
        this.age = age;
    }

    private void method() {
        System.out.println(brand + name + age);
    }

    public static String getColor() {
        return color;
    }
}