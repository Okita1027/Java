package pattern.structor.bride;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 桥接模式测试类
 * @Date 2022/12/21 14:18 星期三
 */
public class Client {
    public static void main(String[] args) {
        Mp4Video video = new Mp4Video();
        OperatingSystem system = new Windows(video);
        system.play("《Violet Ever Garden》");
    }
}
