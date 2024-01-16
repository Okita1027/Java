package classload;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qzy
 * @create 2023/12/29 16:31 星期五
 * @title
 */
public class Demo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2, 3);
        System.out.println("rect.area() = " + rect.area());
        System.out.println("rect.perimeter() = " + rect.perimeter());
        System.out.println("rect.howToDraw() = " + rect.howToDraw());

        String[] arr1 = {"I", "love", "study"};
        String[] arr2 = {"You", "like", "learn"};
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < arr1.length; i++) {
                    System.out.println(arr1[i]);
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < arr2.length; i++) {
                    System.out.println(arr2[i]);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();

        try {
            Thread.sleep(1000);
            System.out.println("===============");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Object object = new Object();
        Thread t1 = new Thread(() -> {
            try {
                synchronized (object) {
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.println(arr1[i]);
                        object.notify();
                        object.wait();
                    }
                    object.notify();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (object) {
                    for (int i = 0; i < arr2.length; i++) {
                        System.out.println(arr2[i]);
                        object.notify();
                        object.wait();
                    }
                    object.notify();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();


    }

    static abstract class Shape {
        protected int length, width;

        public Shape() {
        }

        public Shape(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        abstract int area();

        abstract int perimeter();
    }

    interface Drawable {
        String howToDraw();
    }

    static class Rectangle extends Shape implements Drawable {
        public Rectangle() {
        }

        public Rectangle(int length, int width) {
            super(length, width);
        }

        @Override
        int area() {
            return length * width;
        }

        @Override
        int perimeter() {
            return 2 * (length + width);
        }

        @Override
        public String howToDraw() {
            return "how to draw?";
        }
    }

    @Test
    void numTest() {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i < 100; i += 2) {
                    System.out.print(i + " ");
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 2; i <= 100; i += 2) {
                    System.out.print(i + " ");
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

    }

    @Test
    void FatherSon() {
        Father fs = new Son(1, 2);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.remove(3);
        list.remove(3);
        System.out.println(list.get(3));    //6
    }

}

class Father {
    int age;

    public Father() {
        System.out.println("Father...");
    }

    public Father(int age) {
        this.age = age;
    }
}

class Son extends Father {
    int length;

    public Son(int length, int age) {
//        super(age);
        this.length = length;
        System.out.println("SON");
    }
}