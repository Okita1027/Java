package principle.依赖倒转.after;

/**
 * @version v1.0
 * @ClassName: HardDisk
 * @Description: 硬盘接口
 * @Author: 黑马程序员
 */
public interface HardDisk {

    //存储数据
    public void save(String data);

    //获取数据
    public String get();
}
