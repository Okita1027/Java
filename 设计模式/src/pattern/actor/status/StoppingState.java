package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName StoppingState
 * @Description 具体状态（Concrete State）角色：实现抽象状态所对应的行为。
 * @Date 2022/12/23 17:19 星期五
 */
public class StoppingState extends ElevatorState {

    @Override
    public void open() {
        context.setElevatorState(Context.openingState);
        context.open();
    }

    @Override
    public void close() {
        context.setElevatorState(Context.closingState);
        context.close();
    }

    @Override
    public void run() {
        context.setElevatorState(Context.runningState);
        context.run();
    }

    @Override
    public void stop() {
        //已经停了
    }
}
