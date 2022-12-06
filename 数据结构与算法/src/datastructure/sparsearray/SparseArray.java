package datastructure.sparsearray;

/**
 * @time 2022年5月11日09:50:23
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //11x11的棋盘;0->没有棋子;1->黑子;2->白子
        //初始化棋盘
        int[][] commonArray = new int[11][11];
        commonArray[0][1] = 1;
        commonArray[2][3] = 2;
        commonArray[4][5] = 1;
        commonArray[6][7] = 2;
        //输出原始数组
        System.out.println("原始数组：");
        for (int[] ints : commonArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        //统计原始数组有效元素个数
        int sum = 0;
        for (int[] ints : commonArray) {
            for (int anInt : ints) {
                if (anInt != 0)
                    sum++;
            }
        }
        //将原始数组转换为稀疏数组
        //初始化稀疏数组第一行
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //实现稀疏数组
        int count = 0;
        for (int i = 0; i < commonArray.length; i++) {
            for (int j = 0; j < commonArray[i].length; j++) {
                if (commonArray[i][j] != 0)
                {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = commonArray[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组：");
        for (int[] intRow : sparseArray) {
            for (int intCol : intRow) {
                System.out.print(intCol + "\t");
            }
            System.out.println();
        }
        //将稀疏数组转换为原始数组
        //根据稀疏数组创建原始数组
        int[][] commonArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            commonArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("原始数组：");
        for (int[] intRow : commonArray2) {
            for (int intCol : intRow) {
                System.out.print(intCol + "\t");
            }
            System.out.println();
        }

    }
}
