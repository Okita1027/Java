package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName OpeningState
 * @Description 具体状态（Concrete State）角色：实现抽象状态所对应的行为。
 * @Date 2022/12/23 17:19 星期五
 */
public class OpeningState extends ElevatorState {

    @Override
    public void open() {
        //已经在开了
    }

    @Override
    public void close() {
        //修改状态
        context.setElevatorState(Context.closingState);
        context.getElevatorState().close();
    }

    @Override
    public void run() {
        //电梯门不能开着就跑
    }

    @Override
    public void stop() {
        //开门状态已经是停止的了
    }
}
