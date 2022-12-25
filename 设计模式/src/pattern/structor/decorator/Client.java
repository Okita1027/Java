package pattern.structor.decorator;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 装饰者模式测试
 * @Date 2022/12/20 18:57 星期二
 */
public class Client {
    public static void main(String[] args) {
        //单点一份炒饭
        FriedRice friedRice = new FriedRice();
        System.out.println(friedRice.getDescription() + " = " + friedRice.cost() + "元\n");

        //单点一份炒面
        FastFood friedNoodles = new FriedNoodles();
        System.out.println(friedNoodles.getDescription() + " = " + friedNoodles.cost() + "元\n");
        //给炒面加一个热狗
        friedNoodles = new HotDog(friedNoodles);
        System.out.println(friedNoodles.getDescription() + " = " +friedNoodles.cost() + "元\n");
        //给炒面加一个鸡蛋
        friedNoodles = new Egg(friedNoodles);
        System.out.println(friedNoodles.getDescription() + " = " +friedNoodles.cost() + "元\n");
        //给炒面加再一个鸡蛋
        friedNoodles = new Egg(friedNoodles);
        System.out.println(friedNoodles.getDescription() + " = " +friedNoodles.cost() + "元\n");

    }
}
