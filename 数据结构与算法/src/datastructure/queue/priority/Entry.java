package datastructure.queue.priority;

import datastructure.queue.priority.Priority;

/**
 * @author qzy
 * @time 2023/10/10 11:15 星期二
 * @title 优先队列中的元素类型
 */
public class Entry implements Priority {
    private String value;
    private Integer priority;

    public Entry(String value, Integer priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}
