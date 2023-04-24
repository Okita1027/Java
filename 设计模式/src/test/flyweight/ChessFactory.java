package test.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qzy
 * @ClassName ChessFactory
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 13:38 星期三
 */
public class ChessFactory {
    private Map<String, Chess> map;

    private ChessFactory() {
        map = new HashMap<>(2);
        map.put("black", new BlackChess());
        map.put("white", new WhiteChess());
    }

    public Chess getChess(String color) {
        return map.get(color);
    }

    public static ChessFactory getInstance() {
        return SingletonHolder.FACTORY;
    }

    private static class SingletonHolder {
        private static final ChessFactory FACTORY = new ChessFactory();
    }
}
