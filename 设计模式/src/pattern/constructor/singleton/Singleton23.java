package pattern.constructor.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Date 2022/6/18 11:00 星期六
 * 解决反射破坏单例模式
 * 解决方法请看 Singleton01中的Girlfriend类
 */
public class Singleton23 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<GirlFriend> clazz = GirlFriend.class;
        Constructor<GirlFriend> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        GirlFriend instance = constructor.newInstance();
        GirlFriend instance1 = constructor.newInstance();
        System.out.println(instance1 == instance);
    }
}
