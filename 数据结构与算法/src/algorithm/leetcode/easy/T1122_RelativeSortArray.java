package algorithm.leetcode.easy;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/10 14:51 星期五
 * @title 1122-数组的相对排序
 */
public class T1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 把arr2元素的值为键，下标（权重）为值记录下来
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        ArrayList<Integer> in = new ArrayList<>();  // 参与相对排序
        ArrayList<Integer> out = new ArrayList<>(); // 不参与相对排序
        for (int i = 0; i < arr1.length; i++) {
            // hash表中存在就是参与相对排序，否则不参与相对排序
            if (!map.containsKey(arr1[i])) {
                out.add(arr1[i]);
            } else {
                in.add(arr1[i]);
            }
        }
        Collections.sort(out);  // 正常排序不参与这一组
        in.sort(Comparator.comparingInt(map::get)); // 根据hash表中的下标权重排序参与组
        /* 把排好序的两个合并覆盖arr1 */
        in.addAll(out);
        for (int i = 0; i < in.size(); i++) {
            arr1[i] = in.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        T1122_RelativeSortArray fun = new T1122_RelativeSortArray();
        int[] result = fun.relativeSortArray(arr1, arr2);
        System.out.println("result = " + Arrays.toString(result));
    }
}
