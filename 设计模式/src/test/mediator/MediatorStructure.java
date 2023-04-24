package test.mediator;

/**
 * @Author qzy
 * @ClassName MediatorStructure
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/20 14:47 星期四
 */
public class MediatorStructure extends Mediator {

    public MediatorStructure(Bride bride, BrideGroom brideGroom) {
        super(bride, brideGroom);
    }

    @Override
    protected void proxyConcat(Couple couple, String message) {
        if (couple instanceof BrideGroom) {
            bride.getMessage(message);
        } else if (couple instanceof Bride) {
            brideGroom.getMessage(message);
        }
    }
}
