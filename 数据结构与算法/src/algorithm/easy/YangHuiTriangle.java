package algorithm.easy;

import java.util.Scanner;

/**
 * @Author qzy
 * @ClassName YangHuiTriangle
 * @Description 杨辉三角
 * @Date 2023/1/9 18:29 星期一
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入杨辉三角的层数:");
        int level = scanner.nextInt();
        //给level(控制层数)开辟空间
        int[][] arr = new int[level][];
        //杨辉三角算法
        for (int i = 0; i < arr.length; i++) { //外层遍历行数
            arr[i] = new int[i + 1]; //给每一行数组开辟空间
            for (int j = 0; j < arr[i].length; j++) {
                //若为首或尾个元素则赋值为1
                //否则赋值为上一行前两个元素
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        //利用循环输出二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();  //每遍历一层输出到下一行
        }
    }
}
