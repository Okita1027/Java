package algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * @author Administrator
 * @time 2022/6/11 16:11 星期六
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
public class T1 {

    //初步实现：暴力循环
    //public int[] twoSum(int[] nums, int target) {
    //    for (int i = 0; i < nums.length - 1; i++) {
    //        for (int j = i + 1; j < nums.length; j++) {
    //            if (target == nums[i] + nums[j]) {
    //                return new int[]{i, j};
    //            }
    //        }
    //    }
    //    return null;
    //}

    //进阶实现:哈希表
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            //若要查找的值减去数组当前值已经存在于哈希表中
            if (map.containsKey(target - nums[i])) {
                //则直接返回哈希表中查找值减去当前值的key所对应的value和当前值所对应的下标
                return new int[]{map.get(target - nums[i]), i};
            }
            //否则向哈希表加入此元素值及下标
            map.put(nums[i], i);
        }
        return null;
    }

}
