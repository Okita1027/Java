package pattern.structor.adapter.object_adapter;

/**
 * @Author qzy
 * @ClassName TypeCImpl
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/20 15:42 星期二
 */
public class TypeCImpl implements TypeC {
    private String message;
    @Override
    public String readTypeC() {
        System.out.println("TypeCImpl -> read()");
        return "从手机的TypeC接口读取了信息：HelloWorld!" + message;
    }

    @Override
    public void writeTypeC(String message) {
        this.message = message;
        System.out.println("TypeCImpl -> write()");
    }
}
