package algorithm.leetcode.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qzy
 * @time 2023/10/10 9:44 星期二
 * @title LCR 041数据流中的移动平均值
 * 注意：本题与主站 346 题相同： https://leetcode-cn.com/problems/moving-average-from-data-stream/
 */
public class T346LCR041_MovingAverageDataInStream {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(3);

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println("deque.removeLast = " + deque.removeLast());
        System.out.println("deque.size() = " + deque.size());

    }
}
/*
class MovingAverage {
    Queue<Integer> nums;
    int capacity;
    int sum;
    // Initialize your data structure here.
    public MovingAverage(int size) {
        nums = new ArrayDeque<>();
        capacity = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        // 剔除队列中超过滑动窗口最大个数的元素
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }

}
*/
