package pattern.constructor.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Date 2022/6/18 11:43 星期六
 * Runtime就是利用单例模式实现的
 */
public class RunTimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("ipconfig");
        InputStream inputStream = exec.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = inputStream.read(bytes);
        //控制台默认使用GBK编码
        System.out.println(new String(bytes, 0, len, "GBK"));
        /*int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len, "GBK"));
        }*/
    }
}
