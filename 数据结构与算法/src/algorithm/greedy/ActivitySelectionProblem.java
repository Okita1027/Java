package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/17 10:34 星期五
 * @title 活动选择问题
 *          要在一个会议室举办 n 个活动
 *              每个活动有它们各自的起始和结束时间
 *              找出在时间上互不冲突的活动组合，能够最充分利用会议室（举办的活动次数最多）
 */
public class ActivitySelectionProblem {
    static class Activity {
        int index;
        int start;
        int finish;
        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "Activity(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(0, 1, 3),
                new Activity(2, 3, 5),
                new Activity(1, 2, 4)
        };
        // 根据结束时间排序
        Arrays.sort(activities, Comparator.comparingInt(Activity::getFinish));
        List<Activity> result = select(activities);
        System.out.println("result = " + result);
    }

    private static List<Activity> select(Activity[] activities) {
        ArrayList<Activity> result = new ArrayList<>();
        Activity prev = activities[0];
        result.add(prev);
        for (int i = 1; i < activities.length; i++) {
            Activity curr = activities[i];
            // 当前活动的开始时间在上一个活动结束时间之后，就选择该活动进行，再把该活动当成上一个活动
            if (curr.start >= prev.finish) {
                result.add(curr);
                prev = curr;
            }
        }
        return result;
    }
}
