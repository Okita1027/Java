package test.decorator;

/**
 * @Author qzy
 * @ClassName Cake
 * @Description 抽象构件-生日礼物
 * @Date 2023/4/18 15:27 星期二
 */
public abstract class BirthdayPresent {
    protected String description;

    public BirthdayPresent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
