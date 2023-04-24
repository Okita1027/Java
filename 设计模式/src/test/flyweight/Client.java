package test.flyweight;

/**
 * @Author qzy
 * @ClassName Client
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/19 13:46 星期三
 */
public class Client {
    public static void main(String[] args) {
        ChessFactory factory = ChessFactory.getInstance();
        Chess black = factory.getChess("black");
        Chess black1 = factory.getChess("black");
        Chess white = factory.getChess("white");
        System.out.println(black == black1);//true
        System.out.println(black == white);//false
    }
}
