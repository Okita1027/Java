package algorithm.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qzy
 * @time 2023/11/20 11:22 星期一
 * @title LeetCode47-全排列
 */
public class FullyArranged {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return List.of(List.of(nums[0]));
        }
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, visited, result, stack);
        return result;
    }

        private void backTracking(int[] nums, boolean[] visited, List<List<Integer>> result, LinkedList<Integer> stack) {
        // 如果栈的大小等于数组的长度，表示已经找到了一个满足条件的子集
        if (stack.size() == nums.length) {
            // 将栈中的元素放入一个新的列表中，并将该新列表添加到结果集中
            result.add(new ArrayList<>(stack));
            return;
        }
        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 如果该元素已经被访问过，则跳过
            if (visited[i]) {
                continue;
            }
            // 将当前元素压入栈中，并将其标记为已访问
            stack.push(nums[i]);
            visited[i] = true;
            // 递归调用backTracking函数，继续寻找下一个元素
            backTracking(nums, visited, result, stack);
            // 将栈顶的元素弹出，并将该元素标记为未访问
            stack.pop();
            visited[i] = false;
        }
    }

}
