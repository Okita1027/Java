package algorithm.easy;

import java.util.HashMap;

/**
 * @Author qzy
 * @ClassName MidTimesNumber
 * @Description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例：
 * 数组 {1,7,2,7,-5,7,7}这个数字为7
 * @Date 2023/3/14 20:45 星期二
 */
public class MidTimesNumber {
    public static void main(String[] args) {
        int[] array = {7, 1, 7, 7, 7, 2, 3, 1, 7};
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int count = map.getOrDefault(array[i], 0);
            map.put(array[i], ++count);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) > array.length / 2) {
                System.out.println(array[i]);
                return;
            }
        }
    }
}
