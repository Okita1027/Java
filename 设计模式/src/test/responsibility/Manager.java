package test.responsibility;

/**
 * @Author qzy
 * @ClassName Leader
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 8:52 星期四
 */
public class Manager extends Handler{

    public Manager(Handler nextHandler) {
        super(nextHandler, MANAGER_MAX_DAY_NUM);
    }
    @Override
    protected void deal(int dayNum) {
        System.out.println(this + "-经理-准备处理：" + dayNum);
    }
}
