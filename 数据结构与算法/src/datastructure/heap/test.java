package datastructure.heap;

/**
 * @time 2022/6/5 13:00 星期日
 */
public class test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(5);
        heap.insert(1);
        heap.insert(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        for (int i = 0; i < 5; i++) {
            System.out.println(heap.delMax());
        }
        System.out.println("===============");
        IndexMinPriorityQueue<Integer> queue = new IndexMinPriorityQueue<>(5);
        queue.insert(0, 10);
        queue.insert(1, 25);
        queue.insert(2, 40);
        queue.changeItem(2, 15);
        while (!queue.isEmpty()) {
            int index = queue.delMin();
            System.out.println("index = " + index);
        }
    }
}
