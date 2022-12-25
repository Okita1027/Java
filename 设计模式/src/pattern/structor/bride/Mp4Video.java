package pattern.structor.bride;

/**
 * @Author qzy
 * @ClassName Mp4Video
 * @Description 具体实现化（Concrete Implementor）角色 ：给出实现化角色接口的具体实现。
 * @Date 2022/12/21 14:25 星期三
 */
public class Mp4Video implements Video{
    @Override
    public void decode(String fileName) {
        System.out.println(fileName + ".mp4");
    }
}
