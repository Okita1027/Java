package pattern.constructor.factory.config_factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName CoffeeFactory
 * @Description 改进工厂类(简易版Spring IOC) 简单工厂 + 配置文件
 * @Date 2022/6/18 18:20 星期六
 */
public class CoffeeFactory {
    private static final Map<String, Coffee> map = new HashMap<>();
    static {
        Properties properties = new Properties();
        InputStream is =
                CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(is);
            //遍历Properties集合对象
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                //根据键获取值（全类名）
                String className = properties.getProperty((String) key);
                //获取字节码对象
                Class clazz = Class.forName(className);
                Constructor constructor = clazz.getConstructor();
                Coffee coffee = (Coffee) constructor.newInstance();
                map.put((String) key, coffee);
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
