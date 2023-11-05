package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qzy
 * @time 2023/11/5 15:45 星期日
 * @title 49-字母异位词分组
 */
public class T49_AlphabeticGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            首先，代码使用 Arrays.stream(strs) 将字符串数组转换为流。
            然后，通过调用 collect(Collectors.groupingBy(...)) 方法对流中的元素进行分组。
                groupingBy 方法接受一个 lambda 表达式作为参数，用于指定分组的条件。
                在 lambda 表达式中，首先将字符串 str 转换为字符数组 array，然后使用 Arrays.sort(array) 对字符数组进行排序。排序后的字符数组再转回字符串 new String(array)，作为分组的依据。
            最后，values() 方法将分组的结果以列表形式返回，并使用 ArrayList 构造函数将其封装为 List<List<String>> 类型。
         */
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }
}
