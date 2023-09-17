package algorithm.recursion;

/**
 * @author qzy
 * @time 2023/9/14 8:52 星期四
 * 递归实现二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(array, 3));
    }

    public static int binarySearch(int[] array, int target) {
        return fun(array, target, 0, array.length - 1);
    }

    private static int fun(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >>> 1;
        if (target < array[mid]) {
            return fun(array, target, low, mid - 1);
        } else if (target > array[mid]) {
            return fun(array, target, mid + 1, high);
        } else {
            return mid;
        }
    }
}
