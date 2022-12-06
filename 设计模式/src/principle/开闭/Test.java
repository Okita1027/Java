package principle.开闭;

/**
 * @Date 2022/6/15 22:34 星期三
 * 开闭原则:测试类
 * 对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效
 * 果。简言之，是为了使程序的扩展性好，易于维护和升级。
 */
public class Test {
    public static void main(String[] args) {
        DefaultSkin skin = new DefaultSkin();
        skin.setSkin(new SougouInput());
        skin.showSkin();

        //能够在不改变DefaultSkin的情况下更改输出结果
        skin.setSkin(new FGOInput());
        skin.showSkin();
    }
}
