package test.mediator;

/**
 * @Author qzy
 * @ClassName Couple
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 14:45 星期四
 */
public abstract class Couple {
    protected String name;
    protected Mediator mediator;

    public Couple(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void concat(String message);

    public abstract void getMessage(String message);
}
