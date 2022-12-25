package pattern.structor.adapter.class_adapter;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 测试类
 * @Date 2022/12/20 15:43 星期二
 */
public class Client {
    public static void main(String[] args) {
        //根据TypeC接口读取手机内的信息
        MobilePhone mobilePhone = new MobilePhone();

        //根据TypeC接口写入、读取手机内的信息
        mobilePhone.writeTypeC("这是写入到手机的信息！");
        System.out.println("mobilePhone.readTypeC() = " + mobilePhone.readTypeC() + "\n");

        //使用适配器让手机能通过自身的（TypeC接口）读取U盘的（USB接口）的信息
        TypeCAdapterUSB adapter = new TypeCAdapterUSB();
        String data = mobilePhone.readTypeC(adapter);
        System.out.println("data = " + data);
    }
}
