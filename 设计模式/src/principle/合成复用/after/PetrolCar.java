package principle.合成复用.after;

/**
 * @Author qzy
 * @ClassName PetrolCar
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/17 10:42 星期一
 */
public class PetrolCar extends Car {

    public PetrolCar(Color color) {
        super(color);
    }

    @Override
    public void run() {
        System.out.println();
    }
}
