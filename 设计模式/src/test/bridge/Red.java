package test.bridge;

/**
 * @Author qzy
 * @ClassName Red
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:44 星期三
 */
public class Red implements Color{
    @Override
    public void style(String type) {
        System.out.println("红色的" + type + "形");
    }
}
