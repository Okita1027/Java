package datastructure.dynamic_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author qzy
 * @time 2023/9/12 10:27 星期二
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    /**
     * 当前元素个数
     */
    private int size = 0;
    /**
     * 总容量
     */
    private int capacity = 10;
    private int[] array = {};

    /**
     * 添加到末尾
     * @param element 元素
     */
    public void addLast(int element) {
//        array[size++] = element;
        add(size, element);
    }

    /**
     * 添加
     * @param index 索引
     * @param element 元素
     */
    public void add(int index, int element) {

        checkAndGrow();

        if (index < 0 || index > size) {
            System.out.println("index不合法！");
            return;
        } else if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 扩容数组
     */
    private void checkAndGrow() {
        if (size == 0) {
            //懒加载
            array = new int[capacity];
        } else if (size == capacity) {
            //扩容为1.5倍
            capacity += capacity >>> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 遍历方式1
     * @param consumer 使用消费者接口让调用方决定对遍历的元素做什么
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方式2->迭代器
     * @return Iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 遍历方式3->流
     * @return Stream
     */
    public IntStream intStream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));    //包含0，不包含size
    }

}
