package algorithm.sort;

import java.util.Arrays;

/**
 * @time 2022/6/1 20:36 星期三
 */
public class Test {
    public static void main(String[] args) {
        Integer[] array = {5, 1, 2, 4, 3, 6, 7, 0, 9, 8};
        blobSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
        array = new Integer[]{5, 1, 2, 4, 3, 6, 7, 9, 10, 8};
        selectSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
        array = new Integer[]{5, 1, 2, 4, 3, 6, 7, 9, 0, 8};
        insertSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
        array = new Integer[]{5, 1, 2, 4, 3, 6, 7, 9, 10, 8};
        shellSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
        array = new Integer[]{5, 1, 2, 4, 3, 6, 7, 9, 0, 8};
        mergeSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
        array = new Integer[]{5, 1, 2, 4, 3, 6, 7, 9, 10, 8};
        quickSort(array);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("==============================");
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean more(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void blobSort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (less(array[j + 1], array[j])) {
                    exchange(array, j+1, j);
                }
            }
        }
    }

    private static void selectSort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[mini])) {
                    mini = j;
                }
            }
            if (mini != i) {
                exchange(array, i, mini);
            }
        }
    }

    private static void insertSort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable temp = array[i];
            int index = i - 1;
            while (index >= 0 && less(temp, array[index])) {
                array[index + 1] = array[index];
                array[index] = temp;
                index--;
            }
        }
    }

    private static void shellSort(Comparable[] array) {
        int gap = 1;
        while (gap < array.length / 2) {
            gap = gap * 2 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (less(array[j], array[j - gap])) {
                        exchange(array, j, j - gap);
                    }
                }
            }
            gap /= 2;
        }
    }

    private static Comparable[] assist;
    private static void mergeSort(Comparable[] array) {
        assist = new Comparable[array.length];
        int low = 0;
        int high = array.length - 1;
        mergeSort(array, low, high);
    }

    private static void mergeSort(Comparable[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(Comparable[] array, int low, int mid, int high) {
        int index = low;
        int p1 = low;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            if (less(array[p1], array[p2])) {
                assist[index++] = array[p1++];
            } else {
                assist[index++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            assist[index++] = array[p1++];
        }
        while (p2 <= high) {
            assist[index++] = array[p2++];
        }

        System.arraycopy(assist, 0, array, 0, high + 1);
    }

    private static void quickSort(Comparable[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low ,high);
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private static int partition(Comparable[] array, int low, int high) {
        Comparable key = array[low];
        int left = low;
        int right = high + 1;
        while (true) {
            while (less(key, array[--right])) {
                if (left == right) {
                    break;
                }
            }
            while (less(array[++left], key)) {
                if (left == right) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(array, left, right);
            }
        }
        exchange(array, low, right);
        return right;
    }
}
