package pattern.structor.flyweight;

/**
 * @Author qzy
 * @ClassName JBox
 * @Description 具体享元（Concrete Flyweight）角色 ：它实现了抽象享元类，称为享元对象；在具体享元
 * 类中为内部状态提供了存储空间。通常我们可以结合单例模式来设计具体享元类，为每一个具体享
 * 元类提供唯一的享元对象。
 * @Date 2022/12/21 17:31 星期三
 */
public class JBox extends Box{
    @Override
    public String getShape() {
        return "J";
    }
}
