package pattern.actor.observer;

/**
 * @Author qzy
 * @ClassName Subject
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/23 19:46 星期五
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
