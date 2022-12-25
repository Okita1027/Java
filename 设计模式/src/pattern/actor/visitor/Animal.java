package pattern.actor.visitor;

/**
 * @Author qzy
 * @ClassName Animal
 * @Description 抽象元素（Element）角色：定义了一个接受访问者的方法（ accept ），其意义是指，每一个元
 * 素都要可以被访问者访问。
 * @Date 2022/12/24 19:13 星期六
 */
public interface Animal {
    void accept(Person person);
}
