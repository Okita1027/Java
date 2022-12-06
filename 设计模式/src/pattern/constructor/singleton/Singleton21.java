package pattern.constructor.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Date 2022/6/18 8:41 星期六
 * 通过反射破坏单例模式
 */
public class Singleton21 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Singleton01> clazz = Singleton01.class;
        Constructor<Singleton01> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton01 instance = constructor.newInstance();
        Singleton01 instance1 = constructor.newInstance();
        System.out.println(instance1 == instance);//false
    }
}
