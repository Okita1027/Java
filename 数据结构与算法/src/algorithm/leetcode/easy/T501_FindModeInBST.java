package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author qzy
 * @time 2023/11/29 15:50 星期三
 * @title 二叉搜索树中的众数
 */
public class T501_FindModeInBST {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        loop(root, map);
        /*int maxCount = 1;
        for (Integer count : map.values()) {
            if (maxCount < count) {
                maxCount = count;
            }
        }*/
        Integer maxCount = map.values().stream().max(Comparator.comparingInt(o -> o)).get();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(maxCount)) {
                result.add(key);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void loop(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        loop(root.left, map);
        loop(root.right, map);
    }
}
