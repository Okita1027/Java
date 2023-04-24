package test.mediator;

/**
 * @Author qzy
 * @ClassName Bride
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 14:46 星期四
 */
public class Bride extends Couple{

    public Bride(String name) {
        super(name);
    }

    @Override
    public void concat(String message) {
        mediator.proxyConcat(this, "MSG:我是新郎！" + message);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("收到来自新娘的消息：" + message);
    }
}
