package heima.t1.heap;

/**
 * 堆内存诊断：
 *  1. jps 工具
 *  查看当前系统中有哪些 java 进程
 *  2. jmap 工具
 *  查看堆内存占用情况 jmap - heap 进程id
 *  3. jconsole 工具
 *  图形界面的，多功能的监测工具，可以连续监测
 *  4. jvisualvm 工具
 *  图形界面的，比jconsole更强大
 *  ！以上工具要在JDK1.8下使用！
 */
public class Demo1_4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10]; // 10 Mb
        System.out.println("2...");
        Thread.sleep(20000);
        array = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
