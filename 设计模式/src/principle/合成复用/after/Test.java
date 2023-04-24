package principle.合成复用.after;

/**
 * @Author qzy
 * @ClassName Test
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/17 10:56 星期一
 */
public class Test {
    public static void main(String[] args) {
        Red red = new Red();
        ElectricCar redElectricCar = new ElectricCar(red);
        redElectricCar.run();
    }
}
