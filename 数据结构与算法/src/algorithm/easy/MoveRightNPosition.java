package algorithm.easy;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author qzy
 * @ClassName MoveRightNPosition
 * @Description 将数组一部分元素右移动，溢出部分左置
 * @Date 2023/2/7 21:52 星期二
 */
public class MoveRightNPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 0, 6, 8, 7};
        int n = new Random().nextInt(3) + 3;//随机右移3-6（不包含6）格
        System.out.println("n = " + n);
        System.out.println(Arrays.toString(arr));
        //获取最后n个元素
        int[] lastN = new int[n];
        int count = 0;
        int i = lastN.length - 1;
        int j = arr.length - 1;
        while (count++ < n) {
            lastN[i--] = arr[j--];
        }
        //将arr.length - n个最左边元素移动到最右边
        i = arr.length - 1;
        count = arr.length - n - 1;
        while (count >= 0) {
            arr[i--] = arr[count--];
        }
        //将n个最右边元素移动到最左边
        for (i = 0; i < n; i++) {
            arr[i] = lastN[i];
        }
        System.out.println(Arrays.toString(arr));
        /*//网上答案：
        System.out.println("输入n个整数，再输入m，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数");
        //获取用户的输入,并解析为一个数组
        Scanner sc = new Scanner(System.in);
        System.out.println("请直接输入数组元素，（以逗号作为间隔）");
        String str = sc.next();
        //分割用户输入得到一个字符串数组
        String[] strs = str.split(",|，");
        // 遍历这个字符串数组，将每个字符串解析为一个Integer，并装到Integer数组中
        int[] nums = new int[strs.length];
        int[] exchange = new int[nums.length];
        int m = 0;
        try {
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            //新建一个长度一样的数组
            System.out.println("原数组：" + Arrays.toString(nums));
            //让用户输入m的值
            System.out.println("请输入向后移动的位数m：");
            m = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("你输入有误，请输入数字，其它字符不支持");
        }
        // 遍历两个数组，因为长度一样，所以一个for循环就足够
        for (int i = 0; i < nums.length; i++) {
            // m个数前的情况
            if (i < nums.length - m) {
                exchange[i + m] = nums[i];
            } else if (i >= nums.length - m) {
                // 最后的m个数放到新数组的最前面
                for (int j = 0; j < m; j++) {
                    exchange[j] = nums[nums.length - m + j];
                }
                // 转换完成，退出循环
                break;
            }
        }
        // 输出转换后的结果
        System.out.println("转换后：" + Arrays.toString(exchange));*/
    }
}
