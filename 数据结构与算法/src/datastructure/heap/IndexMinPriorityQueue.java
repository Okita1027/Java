package datastructure.heap;

import java.util.Arrays;

/**
 * @time 2022/6/6 22:17 星期一
 * 索引最小优先队列
 * 之前的最小优先队列可以很方便得每次获取堆中最小的值，
 * 但是不能够方便得修改堆中其它元素的值，故引出索引最小优先队列
 * 在索引最小优先队列中，有三个数组：
 * items存放真实的元素值；pq存放items元素的下标；qp存放pq元素的下标
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int size;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.size = 0;
        //默认情况下数组中没有元素，初始化qp数组元素为-1
        Arrays.fill(qp, -1);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[qp[j]]) < 0;
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //判断K对应的元素是否存在
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    //返回最小元素所关联的索引
    public int minIndex() {
        return pq[1];
    }

    //向对应的位置处插入元素
    public boolean insert(int i, T t) {
        //若i已经被关联，则停止插入
        if (contains(i)) {
            return false;
        }
        ++size;
        //把数据存储到items对应的i位置处
        items[i] = t;
        //把i存储到pq中
        pq[size] = i;
        //通过qp记录pq中的i
        qp[i] = size;
        //完成堆上浮是堆重新有序
        swim(size);
        return true;
    }

    //删除最小元素并返回该元素所关联的索引
    public int delMin() {
        //获取最小元素关联的索引
        int minIndex = pq[1];
        //交换pq中索引1处和最大索引处的元素
        exchange(1, size);
        //同步删除qp中最大索引处的元素
        qp[pq[size]] = -1;
        //删除pq最大索引处的内容
        pq[size] = -1;
        //删除items中存储的源数据
        items[minIndex] = null;
        size--;
        //对堆进行下沉调整使堆重新有序
        sink(1);
        return minIndex;
    }

    //删除i对应的元素
    public void delete(int i) {
        //找到i在pq中的索引
        int k = qp[i];
        //交换pq中索引k处的值和索引N处的值
        exchange(k, size);
        //删除qp中的内容
        qp[pq[size]] = -1;
        //删除pq中的内容
        pq[size] = -1;
        //删除items中的内容
        items[k] = null;
        //元素的数量-1
        size--;
        //堆的调整
        sink(k);
        swim(k);
    }

    public void changeItem(int i, T t) {
        //修改items中数组中i位置的元素t
        items[i] = t;
        //找到i在pq中出现的位置
        int k = qp[i];
        //堆调整
        sink(k);
        swim(k);
    }

    private void sink(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exchange(k, k / 2);
            }
            k /= 2;
        }
    }

    private void swim(int k) {
        while (2 * k <= size) {
            //找到子节点中较小值
            int min;
            if (2 * k + 1 <= size) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }
            //比较当前节点和较小值
            if (less(k, min)) {
                break;
            }
            exchange(k, min);
            k = min;
        }
    }
}
