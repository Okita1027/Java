package pattern.actor.observer;

/**
 * @Author qzy
 * @ClassName WeiXinObserver
 * @Description 具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知
 * 时更新自身的状态。
 * @Date 2022/12/23 19:51 星期五
 */
public class WeiXinObserver implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeiXinObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
