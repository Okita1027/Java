package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/24 15:45 星期六
 */
public class Client {
    public static void main(String[] args) {
        MediatorStructure mediator = new MediatorStructure();

        HouseOwner houseOwner = new HouseOwner("qzy", mediator);
        Pennant pennant = new Pennant("zk", mediator);

        mediator.setPennant(pennant);
        mediator.setHouseOwner(houseOwner);

        //房东向中介告知有房，中介再转说给客户
        houseOwner.contact("这有房可租！");
    }
}
