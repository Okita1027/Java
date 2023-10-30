package lesson.homework.Oct27;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qzy
 * @time 2023/10/30 10:15 星期一
 * @title 第二题
 */
public class Exercise2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2006, "意大利");
        map.put(2002, "巴西");
        map.put(1998, "法国");
        map.put(1990, "巴西");
        map.put(1986, "德国");
        map.put(1982, "阿根廷");
        map.put(1978, "意大利");
        map.put(1974, "德国");
        map.put(1970, "巴西");
        map.put(1966, "英格兰");
        map.put(1962, "巴西");
        map.put(1958, "巴西");
        map.put(1954, "德国");
        map.put(1950, "意大利");
        map.put(1938, "乌拉圭");
        map.put(1934, "意大利");
        map.put(1930, "乌拉圭");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(map.getOrDefault(year, "没有举办世界杯"));
    }
}
