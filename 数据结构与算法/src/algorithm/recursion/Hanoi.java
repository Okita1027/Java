package algorithm.recursion;

import java.util.LinkedList;

/**
 * @author qzy
 * @time 2023/9/15 17:45 星期五
 * 汉诺塔问题
 */
public class Hanoi {
    private static void move(int n, LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {
        if (n == 0) {
            return;
        }
        move(n - 1, A, C, B);   //把n-1个盘子由A，借C，移至B
        C.addLast(A.removeLast()); //把最后一个盘子由A移至C
        print(A, B, C);
        move(n - 1, B, A, C);   //把n-1个盘子由B，借A，移至C

    }

    private static void print(LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {
        System.out.print(A);
        System.out.print(B);
        System.out.print(C);
        System.out.println("\n===============");
    }

    public static void main(String[] args) {
        LinkedList<Integer> A = new LinkedList<>();
        LinkedList<Integer> B = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        move(3, A, B, C);
    }
}
