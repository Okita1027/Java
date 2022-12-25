package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName MediatorStructure
 * @Description 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对
 * 象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * @Date 2022/12/24 15:35 星期六
 */
public class MediatorStructure extends Mediator{

    @Override
    public void contact(Person person, String message) {
        if (person == houseOwner) {
            pennant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }

}
