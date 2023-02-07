package algorithm.easy;

/**
 * @Author qzy
 * @ClassName Matrix
 * @Description 矩阵
 * @Date 2023/1/28 19:50 星期六
 */
public class Matrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);
        matrix.print();
        matrix.translate();
        System.out.println();
        matrix.print();
        System.out.println();
        int[][] ints = {{1, 2}, {3, 4}, {5, 6}};
        matrix.add(ints);
        matrix.print();
    }

    private int[][] matrix;

    public Matrix(int row, int column) {
        matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = i + j;
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //矩阵转置
    public void translate() {
        int[][] copy = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[j][i] = matrix[i][j];
            }
        }
        //重新赋值
        matrix = new int[copy.length][copy[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }

    //矩阵相加
    public void add(int[][] rect) {
        //A矩阵的行数必须等于B矩阵的列数
        if (rect.length != matrix.length || rect[0].length != matrix[0].length)
            return;
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                matrix[i][j] += rect[i][j];
            }
        }
    }

}
