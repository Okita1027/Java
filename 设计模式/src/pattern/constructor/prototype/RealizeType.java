package pattern.constructor.prototype;

/**
 * @Author qzy
 * @Version V1.0
 * @ClassName RealizeType
 * @Description 可克隆类
 * @Date 2022/6/18 21:36 星期六
 * 使用场景：
 *      对象的创建非常复杂，可以使用原型模式快捷的创建对象。
 *      性能和安全要求比较高。
 */
public class RealizeType implements Cloneable {

    private String name;

    public RealizeType() {
        System.out.println("具体原型创建成功！");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("给" + name + "颁发奖状！");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (RealizeType) super.clone();
    }
}
