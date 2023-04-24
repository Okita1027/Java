package test.decorator;

/**
 * @Author qzy
 * @ClassName Fruit
 * @Description 抽象装饰-水果
 * @Date 2023/4/18 15:32 星期二
 */
public abstract class Fruit extends BirthdayPresent {
    private BirthdayPresent birthdayPresent;

    public Fruit(String description, BirthdayPresent birthdayPresent) {
        super(description);
        this.birthdayPresent = birthdayPresent;
    }

    @Override
    public String getDescription() {
        return birthdayPresent.getDescription() + "+" + super.getDescription();
    }
}
