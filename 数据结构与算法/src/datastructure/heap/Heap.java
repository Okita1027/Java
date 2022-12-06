package datastructure.heap;

/**
 * @time 2022/6/5 9:48 星期日
 * 堆：用二叉树实现，特点是每个节点都大于等于他的2个子节点
 */
public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int size;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T value) {
        items[++size] = value;
        swim(size);
    }

    //把插入的元素移动到合适的位置
    private void swim(int k) {
        while (k > 1) {
            if (less(k/2, k)) {
                exchange(k/2, k);
            }
            k = k / 2;
        }
    }

    //删除最大的节点：即根节点
    public T delMax() {
        T max = items[1];
        //最右边的节点暂时和根节点互换
        exchange(size, 1);
        //并删除根节点,元素个数-1
        items[size--] = null;
        sink();
        return max;
    }

    //使用下沉算法，使索引k处的元素能在堆中处于正确的位置
    private void sink() {
        int k = 1;
        while (2 * k <= size) {
            //获取当前节点的较大的子节点的索引
            int max;
            //若当前节点有2个子节点
            if (2 * k + 1 <= size) {
                //就比较这两个节点的大小
                //把大的那个索引赋值给max
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {//如果只有一个左子节点
                //就把这个节点的索引赋给max
                max = 2 * k;
            }
            if (!less(k, max)) {
                break;
            }
            exchange(k, max);
            k = max;
        }
    }

}
