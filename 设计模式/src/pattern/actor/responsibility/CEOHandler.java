package pattern.actor.responsibility;

/**
 * @Author qzy
 * @ClassName Leader
 * @Description 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请
 * 求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 * @Date 2022/12/23 16:04 星期五
 */
public class CEOHandler extends Handler {

    public CEOHandler(Handler nextHandler) {
        super(DAY_NUM_SEVEN, nextHandler);
    }

    @Override
    protected void handlerRequest(Request request) {
        System.out.println("CEO审批：" + request.getName() + "请假" + request.getDayNum() + "天-" + request.getComment());
    }
}
