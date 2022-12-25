package pattern.structor.flyweight;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 享元模式
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
