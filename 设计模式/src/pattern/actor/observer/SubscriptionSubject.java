package pattern.actor.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName SubscriptionSubject
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/23 19:47 星期五
 */
public class SubscriptionSubject implements Subject{

    private final List<Observer> weXinUserList;

    public SubscriptionSubject() {
        weXinUserList = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        weXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer weiXinUser : weXinUserList) {
            weiXinUser.update(message);
        }
    }
}
