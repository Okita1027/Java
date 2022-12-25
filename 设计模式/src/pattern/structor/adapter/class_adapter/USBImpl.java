package pattern.structor.adapter.class_adapter;

/**
 * @Author qzy
 * @ClassName USBImpl
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/20 15:40 星期二
 */
public class USBImpl implements USB {
    private String message;
    @Override
    public String readUSB() {
        System.out.println("USBImpl -> read()");
        return "从U盘中读取了信息：HelloWorld!" + message;
    }

    @Override
    public void writeUSB(String message) {
        this.message = message;
        System.out.println("USBImpl -> write()");
    }
}
