package pattern.structor.decorator;

/**
 * @Author qzy
 * @ClassName FastFood
 * @Description 快餐类：抽象构件（Component）角色 ：定义一个抽象接口以规范准备接收附加责任的对象。
 * @Date 2022/12/20 17:31 星期二
 */
public abstract class FastFood {
    private double price;
    private String description;

    //计算价格
    public abstract double cost();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FastFood(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public FastFood() {
    }
}
