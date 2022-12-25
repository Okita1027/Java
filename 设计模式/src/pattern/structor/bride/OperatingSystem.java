package pattern.structor.bride;

/**
 * @Author qzy
 * @ClassName OperatingSystem
 * @Description 抽象化（Abstraction）角色 ：定义抽象类，并包含一个对实现化对象的引用
 * @Date 2022/12/21 14:23 星期三
 */
public abstract class OperatingSystem {
    protected Video video;

    public OperatingSystem(Video video) {
        this.video = video;
    }

    public abstract void play(String fileName);
}
