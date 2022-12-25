package pattern.structor.adapter.object_adapter;

/**
 * @Author qzy
 * @ClassName TypeCAdapterUSB
 * @Description 适配器类：让手机的TypeC 口 可以读取 U盘的 USB口
 *              对象适配器：符合"合成复用"原则
 * @Date 2022/12/20 15:45 星期二
 */
public class TypeCAdapterUSB implements TypeC {
    private final USB usb;

    public TypeCAdapterUSB(USB usb) {
        this.usb = usb;
    }

    @Override
    public String readTypeC() {
        System.out.println("执行适配器……");
        return usb.readUSB();
    }

    @Override
    public void writeTypeC(String message) {
        System.out.println("执行适配器……");
        usb.writeUSB(message);
    }

}