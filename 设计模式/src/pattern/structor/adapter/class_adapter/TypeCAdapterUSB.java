package pattern.structor.adapter.class_adapter;

/**
 * @Author qzy
 * @ClassName TypeCAdapterUSB
 * @Description 适配器类：让手机的TypeC 口 可以读取 U盘的 USB口
 * 类适配器模式违背了合成复用原则。类适配器是客户类有一个接口规范的情况下可用，反之不可用。
 * @Date 2022/12/20 15:45 星期二
 */
public class TypeCAdapterUSB extends USBImpl implements TypeC {
    @Override
    public String readTypeC() {
        System.out.println("执行适配器……");
        return super.readUSB();
    }

    @Override
    public void writeTypeC(String message) {
        System.out.println("执行适配器……");
        super.writeUSB(message);
    }

}