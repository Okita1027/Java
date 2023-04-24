package test.mediator;

/**
 * @Author qzy
 * @ClassName Mediator
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 14:47 星期四
 */
public abstract class Mediator {
    protected Bride bride;
    protected BrideGroom brideGroom;

    public Mediator(Bride bride, BrideGroom brideGroom) {
        this.bride = bride;
        this.brideGroom = brideGroom;
    }

    protected abstract void proxyConcat(Couple couple, String message);
}
