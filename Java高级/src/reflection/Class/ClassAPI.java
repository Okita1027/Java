package reflection.Class;

import java.lang.reflect.Field;

/**
 * @time 2022/5/4 17:39 星期三
 * Class类介绍
 * */
public class ClassAPI {
    public static void main(String[] args) throws Exception {
        /*
         * 1.Class也是类,因此也继承Object类
         * 2.Class类对象不是new出来的，而是系统创建的
         * 3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
         * 4.每个类的实例都会记得自己是由哪个Class 实例所生成
         * 5.通过Class对象可以完整地得到一个类的完整结构,通过一系列API
         * 6.Class对象是存放在堆的
         * 7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码变量名，方法名，访问权限等等)
         * */

        String classPath = "Class.Dog";
        //获取Dog类对应的Class对象
        Class<?> dog1 = Class.forName(classPath);
        Class<?> dog2 = Class.forName(classPath);
        //因为同一个类只加载一次，所以dog1.hashCode() == dog2.hashCode()
        System.out.println(dog1.hashCode());
        System.out.println(dog2.hashCode());
        Class<?> cls = Class.forName("reflection.Class.CatC");
        System.out.println(cls.hashCode());

        //输出cat是哪个类的Class对象
        System.out.println(cls);
        //输出实际运行类型
        System.out.println(cls.getClass());
        //得到包名
        System.out.println(cls.getPackage().getName());
        //得到类名
        System.out.println(cls.getName());
        //生成对象实例
        CatC catC = (CatC) cls.newInstance();
        System.out.println(catC);
        //通过反射获取属性
        Field color = cls.getField("color");
        System.out.println(color.get(catC));
        //通过反射给属性赋值
        color.set(catC, "橘黄色");
        System.out.println(color.get(catC));
        //得到所有属性
        System.out.print("所有字段：");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.print(field.getName() + "\t");
        }

    }
}
