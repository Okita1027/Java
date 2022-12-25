package pattern.actor.visitor;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 访问者模式
 * @Date 2022/12/24 19:24 星期六
 */
public class Client {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());

        Myself myself = new Myself();

        home.action(myself);
        System.out.println();
        home.action(new Others());
    }
}
