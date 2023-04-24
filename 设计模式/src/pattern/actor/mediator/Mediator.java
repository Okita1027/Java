package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName Mediator
 * @Description 抽象中介者（Mediator）角色
 * @Date 2022/12/24 15:26 星期六
 */
public abstract class Mediator {
    /**
     * 房屋所有者
     */
    protected HouseOwner houseOwner;
    /**
     * 租房者
     */
    protected Pennant pennant;

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setPennant(Pennant pennant) {
        this.pennant = pennant;
    }

    /**
     * 联系出租者与租房者
     * @param person 出租者 或者是 租房者
     * @param message 传递的消息
     */
    public abstract void contact(Person person, String message);
}
