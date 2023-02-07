package test.program;

import java.io.*;

/**
 * @Author qzy
 * @ClassName IOExercise
 * @Description //编写一个Java程序将当100,101,102,103,104,105个数以数组的形式写入到Dest.txt文件中，并以相反的顺序读出显示在屏幕上。
 * @Date 2023/2/6 21:53 星期一
 */
public class IOExercise {
    public static void main(String[] args) throws IOException {
        //编写一个Java程序将当100,101,102,103,104,105个数以数组的形式写入到Dest.txt文件中，并以相反的顺序读出显示在屏幕上。
        String[] array = {"100", "101", "102", "103", "104", "105"};
        final BufferedWriter writer = new BufferedWriter(new FileWriter("F:/Dest.txt"));
        writer.write("[");
        for (int i = 0; i < array.length; i++) {
            writer.write(array[i]);
            if (i != array.length - 1) {
                writer.write(",");
            }
        }
        writer.write("]");
        writer.close();

        FileReader reader = new FileReader("F:/Dest.txt");
        char[] chars = new char[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = reader.read(chars)) != -1) {
            stringBuilder.append(new String(chars, 0, len));
        }
        reader.close();
        String substring = stringBuilder.substring(1, stringBuilder.length() - 1);
        String[] split = substring.split(",");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i]);
        }
    }
}

