package algorithm.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author qzy
 * @time 2023/10/10 10:39 星期二
 * @title 最近的请求次数
 * 注意：本题与主站 933 题相同： https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class T933LCR042_LatestRequestTimes {
/*    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(100);
        queue.offer(3001);
        queue.offer(3002);
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

    }*/
}

/*class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        // 不断判定队首的元素是否在[t-3000~t]之间
        while (queue.peek() < t - 3000) {
            // 剔除不符合要求的元素
            queue.poll();
        }
        return queue.size();
    }
}*/
