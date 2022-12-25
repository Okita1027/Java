package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName ClosingState
 * @Description 具体状态（Concrete State）角色：实现抽象状态所对应的行为。
 * @Date 2022/12/23 17:19 星期五
 */
public class ClosingState extends ElevatorState {

    @Override
    public void open() {
        context.setElevatorState(Context.openingState);
        context.open();
    }

    @Override
    public void close() {
        //已经在关了
    }

    @Override
    public void run() {
        //电梯门关了就跑
        context.setElevatorState(Context.runningState);
        context.run();
    }

    @Override
    public void stop() {
        //门关了，但可以不按楼层
        context.setElevatorState(Context.stoppingState);
        context.stop();
    }
}
