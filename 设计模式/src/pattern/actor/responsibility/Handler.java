package pattern.actor.responsibility;

/**
 * @Author qzy
 * @ClassName Handler
 * @Description 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * @Date 2022/12/23 15:31 星期五
 */
public abstract class Handler {
    protected static final int DAY_NUM_ONE = 1;
    protected static final int DAY_NUM_THREE = 3;
    protected static final int DAY_NUM_SEVEN = 7;

    //所能处理的最大天数
    private int dayNumLimit;
    //下一个处理者
    private Handler nextHandler;

    public Handler(int dayNumLimit, Handler nextHandler) {
        this.dayNumLimit = dayNumLimit;
        this.nextHandler = nextHandler;
    }

    public int getDayNumLimit() {
        return dayNumLimit;
    }

    public void setDayNumLimit(int dayNumLimit) {
        this.dayNumLimit = dayNumLimit;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handlerRequest(Request request);

    public final void submit(Request request) {
        if (request.getDayNum() > DAY_NUM_SEVEN) {
            System.out.println("天数过长，无人审批！");
        } else if (dayNumLimit < request.getDayNum() && null != nextHandler) {
            nextHandler.submit(request);
        }  else {
            handlerRequest(request);
        }
    }
}
