package principle.依赖倒转.after;

/**
 * @version v1.0
 * @ClassName: IntelCpu
 * @Description: Intel cpu
 * @Author: 黑马程序员
 */
public class IntelCpu implements Cpu {

    @Override
    public void run() {
        System.out.println("使用Intel处理器");
    }
}
