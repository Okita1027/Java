package newfeatures;

import java.util.Optional;

/**
 * @author qzy
 * @time 2023/9/17 8:31 星期日
 * Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型 T 的值，代
 * 表这个值存在。或者仅仅保存 null，表示这个值不存在。如果值存在，则
 * isPresent()方法会返回 true，调用 get()方法会返回该对象。
 */
public class Optional_ {
    public static void main(String[] args) {
        Optional<Integer> i = Optional.of(10);
        System.out.println(i);
        System.out.println(i.get());
    }
}
