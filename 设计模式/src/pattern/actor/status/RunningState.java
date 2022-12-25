package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName RunningState
 * @Description 具体状态（Concrete State）角色：实现抽象状态所对应的行为。
 * @Date 2022/12/23 17:19 星期五
 */
public class RunningState extends ElevatorState {

    @Override
    public void open() {
        //运行期间不能关门
    }

    @Override
    public void close() {
        //运行期间门肯定是关的
    }

    @Override
    public void run() {
        //已经在运行了
    }

    @Override
    public void stop() {
        context.setElevatorState(Context.stoppingState);
        context.stop();
    }
}
