package pattern.actor.visitor;

/**
 * @Author qzy
 * @ClassName Myself
 * @Description 具体访问者（ConcreteVisitor）角色：给出对每一个元素类访问时所产生的具体行为。
 * @Date 2022/12/24 19:18 星期六
 */
public class Myself implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("Myself feed dog!");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("Myself feed cat!");
    }
}
