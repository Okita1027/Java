package pattern.structor.flyweight;

import java.util.HashMap;

/**
 * @Author qzy
 * @ClassName BoxFactory
 * @Description 非享元（Unsharable Flyweight)角色 ：并不是所有的抽象享元类的子类都需要被共享，不
 * 能被共享的子类可设计为非共享具体享元类；当需要一个非共享具体享元类的对象时可以直接通过实例化创建。
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
