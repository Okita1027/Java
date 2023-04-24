package pattern.structor.flyweight;

import java.util.HashMap;

/**
 * @Author qzy
 * @ClassName BoxFactory
 * @Description 享元工厂（Flyweight Factory）角色 ：负责创建和管理享元角色。当客户对象请求一个享元
 * 对象时，享元工厂检査系统中是否存在符合要求的享元对象，如果存在则提供给客户；如果不存在
 * 的话，则创建一个新的享元对象。
 * @Date 2022/12/21 17:32 星期三
 */
public class BoxFactory {

    private static HashMap<String, Box> map;

    /*
        静态内部类实现单例
     */
    private BoxFactory() {
        map = new HashMap<>();
        map.put("L", new LBox());
        map.put("J", new JBox());
    }
    private static class SingletonHolder {
        private static final BoxFactory INSTANCE = new BoxFactory();
    }
    public static BoxFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //获取共享的对象
    public Box getBox(String key) {
        return map.get(key);
    }
}
