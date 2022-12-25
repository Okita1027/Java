package pattern.actor.observer;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 观察者模式
 * @Date 2022/12/23 19:54 星期五
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();
        subject.attach(new WeiXinObserver("qzy"));
        subject.attach(new WeiXinObserver("zk"));
        subject.attach(new WeiXinObserver("jh"));
        subject.attach(new WeiXinObserver("hlf"));

        subject.notify("this is a new message:you are notified!");
    }
}
