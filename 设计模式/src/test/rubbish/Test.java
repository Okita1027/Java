package test.rubbish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author qzy
 * @ClassName Test
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 11:08 星期三
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("A", "A");
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("A", "AA");
        map1.put("B", "BB");
        map.putAll(map1);
        System.out.println(map);
    }
}
