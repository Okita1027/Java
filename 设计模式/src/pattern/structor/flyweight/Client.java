package pattern.structor.flyweight;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 享元模式
 * 非享元（Unsharable Flyweight)角色 ：并不是所有的抽象享元类的子类都需要被共享，不
 * 能被共享的子类可设计为非共享具体享元类；当需要一个非共享具体享元类的对象时可以直接通过实例化创建。
 * @Date 2022/12/21 20:03 星期三
 */
public class Client {
    public static void main(String[] args) {
        BoxFactory instance = BoxFactory.getInstance();
        Box boxJ = instance.getBox("J");
        boxJ.display("Blue");

        Box boxL = instance.getBox("L");
        boxL.display("Red");

        Box boxL2 = instance.getBox("L");
        boxL2.display("Green");

        System.out.println(boxL == boxL2);//true

    }
}
