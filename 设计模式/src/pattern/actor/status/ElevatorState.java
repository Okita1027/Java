package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName ElevatorState
 * @Description 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为。
 * @Date 2022/12/23 17:04 星期五
 */
public abstract class ElevatorState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();

}
