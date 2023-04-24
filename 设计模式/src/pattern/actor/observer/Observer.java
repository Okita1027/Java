package pattern.actor.observer;

/**
 * @Author qzy
 * @ClassName Observer
 * @Description 抽象观察者，是观察者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
 * @Date 2022/12/23 19:43 星期五
 */
public interface Observer {
    void update(String message);
}
