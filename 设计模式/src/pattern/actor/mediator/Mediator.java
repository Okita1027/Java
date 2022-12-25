package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName Mediator
 * @Description 抽象中介者（Mediator）角色
 * @Date 2022/12/24 15:26 星期六
 */
public abstract class Mediator {
    protected HouseOwner houseOwner;
    protected Pennant pennant;

    public Mediator() {
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setPennant(Pennant pennant) {
        this.pennant = pennant;
    }

    public abstract void contact(Person person, String message);
}
