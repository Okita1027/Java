package pattern.actor.visitor;

/**
 * @Author qzy
 * @ClassName DOg
 * @Description 具体元素（ConcreteElement）角色： 提供接受访问方法的具体实现，而这个具体的实现，通
 * 常情况下是使用访问者提供的访问该元素类的方法。
 * @Date 2022/12/24 19:18 星期六
 */
public class Dog implements Animal {
    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("汪汪汪！");
    }
}
