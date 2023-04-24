package pattern.structor.adapter.object_adapter;

/**
 * @Author qzy
 * @ClassName MobilePhone
 * @Description 手机
 * @Date 2022/12/20 16:06 星期二
 */
public class MobilePhone extends TypeCImpl {
    public String readTypeC(TypeC typeC) {
        if (typeC == null) {
            throw new NullPointerException("typeC can't be null!");
        }
        return typeC.readTypeC();
    }

    public void writeTypeC(TypeC typeC, String message) {
        if (typeC == null) {
            throw new NullPointerException("typeC can't be null!");
        }
        typeC.writeTypeC(message);
    }
}
