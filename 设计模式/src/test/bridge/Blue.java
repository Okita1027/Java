package test.bridge;

/**
 * @Author qzy
 * @ClassName Blue
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 9:43 星期三
 */
public class Blue implements Color {
    @Override
    public void style(String type) {
        System.out.println("蓝色的" + type + "形");
    }
}
