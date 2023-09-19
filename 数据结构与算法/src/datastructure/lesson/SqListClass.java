package datastructure.lesson;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SqListClass<E> {       //顺序表泛型类
    final int initcapacity = 10;    //顺序表的初始容量(常量)
    private int capacity;           //存放顺序表的容量
    public E[] data;                //存放顺序表中元素
    public int size;                //存放顺序表的长度


    public SqListClass() {  //构造方法，实现data和length的初始化
        // 完成：类的初始化，为data分配空间、size和capacity的初始化
        data = (E[]) new Object[initcapacity];
        size = 0;
        capacity = initcapacity;
    }

    //线性表的基本运算算法
    public void CreateList(E[] a) { //由a整体建立顺序表
        size = 0;
        for (E e : a) {
            if (size == capacity) { //出现上溢出时
                updateCapacity(2 * size);   //扩大容量
            }
            // 完成：将a的值赋给data
            data[size++] = e;
        }
    }

    public void Add(E e) {      //在线性表的末尾添加一个值e
        if (size == capacity) { //顺序表空间满时倍增容量
            updateCapacity(2 * size);
        }
        // 完成：在顺序表末尾添加值e
        data[size++] = e;
    }

    public int size() { // 求线性表长度
        return size;
    }

    public void Setsize(int nlen) {    //设置线性表的长度
        if (nlen < 0 || nlen > size) {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        size = nlen;
    }

    public E GetElem(int i) {    //返回线性表中序号为i的元素
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        return (E) data[i];
    }

    public void SetElem(int i, E e) {    //设置序号i的元素为e
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        data[i] = e;
    }

    public int GetNo(E e) { //查找第一个为e的元素的序号
        int i = 0;
        while (i < size && !data[i].equals(e)) {
            i++;            //查找元素e
        }
        if (i >= size) {    //未找到时返回-1
            return -1;
        } else {
            return i;       //找到后返回其序号
        }
    }

    public void swap(int i, int j) {   // i，j是下标
        //完成：交换data[i]和data[j]
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void Insert(int i, E e) {    //在线性表中序号i位置插入元素e
        if (i < 0 || i > size) {        //参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        if (size == capacity) {         //满时倍增容量
            updateCapacity(2 * size);
        }
        // 完成：将i位置之后的所有元素后移，然后将e插入到i位置
        System.arraycopy(data, i, data, i + 1, size - i);
        data[i] = e;
        size++;
    }

    public void Delete(int i) {         //在线性表中删除序号i位置的元素
        if (i < 0 || i > size - 1) {    //参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        // 完成：将i位置之后的所有元素前移
        System.arraycopy(data, i + 1, data, i, size - i - 1);
        // 完成：检查size是否是capacity的1/4，如果是则压缩容量为原来的1/2
        if (size <= capacity / 4) {
            capacity /= 2;
        }
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        size--;
    }

    @Override
        public String toString() {    //将线性表转换为字符串
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans += data[i] + " ";
        }
        return ans;
    }

    private void updateCapacity(int newCapacity) {  //改变顺序表的容量为newCapacity
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i <size; i++) {
            newData[i] = data[i];
        }
        this.capacity = newCapacity; //设置新容量
        this.data = newData;         //仍由data标识数组
    }

    public static void main(String[] args) {
        // 完成：创建一个长度为4的整型数的顺序表，并输出顺序表的值和长度
        System.out.println("*******测试1****************");
        SqListClass<Integer> list = new SqListClass<>();
        Integer[] ints = {1, 2, 3, 4};
        list.CreateList(ints);
        System.out.println("list = " + list);
        // 完成：在顺序表中的末尾增加1个值为10的元素，并输出整个顺序表
        list.Insert(list.size(), 10);
        System.out.println("list = " + list);
        // 完成：在第2位插入一个元素，并输出整个顺序表
        int i = 2;
        int x = 20;
        list.Insert(i, x);
        System.out.println("list = " + list);
        // 完成：删除i位置的元素
        i = 3;
        list.Delete(i);
        System.out.println("list = " + list);
        // 完成：输出位置1的元素值
        i = 1;
        System.out.println("list.GetElem(1) = " + list.GetElem(1));
        
    }

    @Test
    void Example23() {
        int i = 1, k = 2;

        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        System.arraycopy(chars, i + k, chars, i, k);
    }

}
