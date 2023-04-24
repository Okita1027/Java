package test.decorator;

/**
 * @Author qzy
 * @ClassName Mongo
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/18 15:35 星期二
 */
public class Mongo extends Fruit{
    public Mongo(BirthdayPresent birthdayPresent) {
        super("芒果", birthdayPresent);
    }
}
