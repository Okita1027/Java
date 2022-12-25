package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName HouseOwner
 * @Description 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交
 * 互时，由中介者对象负责后续的交互。
 * @Date 2022/12/24 15:31 星期六
 */
public class HouseOwner extends Person {
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    protected void contact(String message) {
        mediator.contact(this, message);
    }

    @Override
    protected void getMessage(String message) {
        System.out.println("houseOwner收到消息：" + message);
    }
}
