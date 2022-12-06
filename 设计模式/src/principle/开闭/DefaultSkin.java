package principle.开闭;

/**
 * @Date 2022/6/15 22:33 星期三
 * 开闭原则:默认输入法
 */
public class DefaultSkin extends AbstractSkin {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    @Override
    public void showSkin() {
        skin.showSkin();
    }
}
