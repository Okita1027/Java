package datastructure.queue;

/**
 * @time 2022/5/28 14:12 星期六
 * 用数组模拟循环队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //循环队列约定空出一个空间作为判断队列满的标识,传进去4，实际只能存储3个元素
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        System.out.println(circleArrayQueue.isEmpty());
        System.out.println(circleArrayQueue.isFull());
        circleArrayQueue.addElement(1);
        circleArrayQueue.addElement(2);
        circleArrayQueue.addElement(3);
        System.out.println(circleArrayQueue.isFull());
        circleArrayQueue.showQueue();

        System.out.println(circleArrayQueue.getElement());
        circleArrayQueue.addElement(0);
        circleArrayQueue.showQueue();

    }
}

