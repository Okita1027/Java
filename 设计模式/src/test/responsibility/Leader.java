package test.responsibility;

/**
 * @Author qzy
 * @ClassName Leader
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 8:52 星期四
 */
public class Leader extends Handler {

    public Leader(Handler nextHandler) {
        super(nextHandler, LEADER_MAX_DAY_NUM);
    }

    @Override
    protected void deal(int dayNum) {
        System.out.println(this + "-领导-准备处理：" + dayNum);
    }
}
