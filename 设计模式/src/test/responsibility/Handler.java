package test.responsibility;

/**
 * @Author qzy
 * @ClassName Handler
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 8:48 星期四
 */
public abstract class Handler {
    protected static final int LEADER_MAX_DAY_NUM = 1;
    protected static final int GROUP_MAX_DAY_NUM = 3;
    protected static final int MANAGER_MAX_DAY_NUM = 7;

    private Handler nextHandler;
    private int limitDayNum;

    public Handler(Handler nextHandler, int limitDayNum) {
        this.nextHandler = nextHandler;
        this.limitDayNum = limitDayNum;
    }

    protected abstract void deal(int dayNum);

    public final void handle(int dayNum) {
        if (dayNum > MANAGER_MAX_DAY_NUM) {
            System.out.println("不可能处理该请求！");
        } else if (dayNum > limitDayNum && nextHandler != null) {
            System.out.println(this + "无法处理该请求，转交给下一位……");
            nextHandler.handle(dayNum);
        } else {
            deal(dayNum);
            System.out.println(this + "处理完毕" + dayNum);
        }
    }
}
