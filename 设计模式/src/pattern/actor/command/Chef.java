package pattern.actor.command;

/**
 * @Author qzy
 * @ClassName Chef
 * @Description 大厨-实现者/接收者（Receiver）角色： 接收者，真正执行命令的对象。任何类都可能成为一个接收
 * 者，只要它能够实现命令要求实现的相应功能。
 * @Date 2022/12/22 19:16 星期四
 */
public class Chef {
    public void cook(String foodName, int foodNum) {
        System.out.println("--" + foodNum + "份" + foodName);
    }
}
