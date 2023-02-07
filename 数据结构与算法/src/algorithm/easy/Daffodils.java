package algorithm.easy;

/**
 * @Author qzy
 * @ClassName T3
 * @Description 水仙花
 * @Date 2023/1/9 16:32 星期一
 */
public class Daffodils {
    public static void main(String[] args) {
        int hundred;
        int ten;
        int Individual;
        for (int i = 100, j = 1; i < 1000; i++) {
            hundred = i / 100;
            ten = i % 100 / 10;
            Individual = i % 10;
            if (hundred * hundred * hundred + ten * ten * ten + Individual * Individual * Individual == i) {
                System.out.println("第" + j++ + "个水仙花数为：" + i);
            }
        }
    }
}
