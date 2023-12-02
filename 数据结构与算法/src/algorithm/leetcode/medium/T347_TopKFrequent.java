package algorithm.leetcode.medium;

import java.util.*;

/**
 * @author qzy
 * @time 2023/11/23 10:30 星期四
 * @title 前K个高频元素
 */
public class T347_TopKFrequent {
    public static void main(String[] args) {
        int[] source = {4, 1, 1, 1, 2, 2, 3};
        T347_TopKFrequent fun = new T347_TopKFrequent();
        System.out.println("source = " + Arrays.toString(source));
        System.out.println(Arrays.toString(fun.topKFrequent(source, 2)));

        source = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println("source = " + Arrays.toString(source));
        System.out.println(Arrays.toString(fun.topKFrequent(source, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {//依次从队头弹出k个,就是出现频率前k高的元素
            res[i] = pq.poll()[0];
        }
        return res;
    }

}
