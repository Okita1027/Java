package test.mediator;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 14:58 星期四
 */
public class Client {
    public static void main(String[] args) {
        Bride husband = new Bride("ABC");
        BrideGroom wife = new BrideGroom("XYZ");
        MediatorStructure mediator = new MediatorStructure(husband, wife);
        husband.setMediator(mediator);
        wife.setMediator(mediator);
        husband.concat("你好，wife！");

    }
}
