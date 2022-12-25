package pattern.actor.status;

/**
 * @Author qzy
 * @ClassName Context
 * @Description 环境（Context）角色：也称为上下文，它定义了客户程序需要的接口，维护一个当前状态，并
 * 将与状态相关的操作委托给当前状态对象来处理。
 * @Date 2022/12/23 16:48 星期五
 */
public class Context {
    public static final OpeningState openingState = new OpeningState();
    public static final ClosingState closingState = new ClosingState();
    public static final RunningState runningState = new RunningState();
    public static final StoppingState stoppingState = new StoppingState();

    private ElevatorState elevatorState;

    public Context(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public void open() {
        elevatorState.open();
    }
    public void close() {
        elevatorState.close();
    }
    public void run() {
        elevatorState.run();
    }
    public void stop() {
        elevatorState.stop();
    }

}
