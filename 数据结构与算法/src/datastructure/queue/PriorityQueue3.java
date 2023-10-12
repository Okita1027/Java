package datastructure.queue;

/**
 * @author qzy
 * @time 2023/10/12 15:18 星期四
 * @title 优先级队列（堆实现）
 */
public class PriorityQueue3<E extends Priority> implements Queue<E>  {
    Priority[] array;
    int size;
    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        int child = size++; // 下一个元素的位置
        int parent = (child - 1) / 2;   // 父节点计算公式
        // 比较要加入的(子）结点与父节点的优先级
        while (child != 0 && e.priority() > array[parent].priority()) {
            // 若子节点优先级比父节点高，则将父节点变成子节点
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        // 子节点不比父节点优先级高了，将要加入的元素赋值给此结点
        array[child] = e;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // 交换堆顶与堆底元素
        swap(0, size--);
        // 记录最大值
        Priority e = array[size];
        // 帮助垃圾回收
        array[size] = null;
        // 下潜
        down(0);
        return (E) e;
    }


    private void down(int parent) {
        int leftChild = 2 * parent + 1;
        int rightChild = leftChild + 1;
        // 假设父节点的优先级最高
        int max = parent;
        // 记录左孩子和右孩子和父节点中优先级最高的元素
        if (leftChild < size && array[leftChild].priority() > array[max].priority()) {
            max = leftChild;
        }
        if (rightChild < size && array[rightChild].priority() > array[max].priority()) {
            max = rightChild;
        }
        // 父节点的优先级不是最高的
        if (max != parent) {
            //交换孩子与父亲
            swap(max, parent);
            //递归判断下一个父子结点
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
