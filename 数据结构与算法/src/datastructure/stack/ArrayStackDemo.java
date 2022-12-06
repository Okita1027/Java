package datastructure.stack;

import java.util.Stack;

/**
 * @time 2022/5/28 19:28 星期六
 * 数组栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.isFull());
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(2);
        arrayStack.showStack();
        System.out.println("===============");
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.showStack();

        System.out.println("===============");
        String s = "((北京)(长江)";
        System.out.println(ArrayStack.isMatch(s));
    }
}

class ArrayStack<T> {
    private int top;
    private T[] data;

    public ArrayStack(int maxSize) {
        top = -1;
        data = (T[]) new Object[maxSize];
    }

    protected boolean isFull() {
        return top == data.length - 1;
    }

    protected boolean isEmpty() {
        return top == -1;
    }

    protected boolean push(T value) {
        if (isFull()) {
            throw new RuntimeException("栈已满！");
        }
        data[++top] = value;
        return true;
    }

    protected T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return data[top--];
    }

    protected void showStack() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("ArrayStack[%d]=%d\n", i, data[i]);
        }
    }

    //栈应用：括号匹配问题
    protected static boolean isMatch(String str) {
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String ch = str.charAt(i) + "";
            if ("(".equals(ch)) {
                strings.push(ch);
            } else if (")".equals(ch)) {
                String pop = strings.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        return strings.size() == 0;
    }

}
