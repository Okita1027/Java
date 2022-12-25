package pattern.actor.mediator;

/**
 * @Author qzy
 * @ClassName Person
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/24 15:26 星期六
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    protected abstract void contact(String message);

    protected abstract void getMessage(String message);
}
