package pattern.structor.bride;

/**
 * @Author qzy
 * @ClassName Windows
 * @Description 实现化（Implementor）角色 ：定义实现化角色的接口，供扩展抽象化角色调用。
 * @Date 2022/12/21 14:31 星期三
 */
public class Windows extends OperatingSystem{
    public Windows(Video video) {
        super(video);
    }

    @Override
    public void play(String fileName) {
        System.out.print("Windows系统正在播放:");
        video.decode(fileName);
    }

}
