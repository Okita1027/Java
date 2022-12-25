package pattern.structor.facade;

/**
 * @Author qzy
 * @ClassName XiaoAiClassmate
 * @Description 外观（Facade）角色：为多个子系统对外提供一个共同的接口。
 * @Date 2022/12/21 15:01 星期三
 */
public class XiaoAiClassmate {
    private Light light;
    private TV tv;

    public XiaoAiClassmate() {
        light = new Light();
        tv = new TV();
    }

    public void voiceControl(String message) {
        if (message.contains("开")) {
            on();
        } else if (message.contains("关")) {
            off();
        } else {
            System.out.println("听不懂！");
        }
    }

    private void on() {
        light.on();
        tv.on();
    }

    private void off() {
        light.off();
        tv.off();
    }
}
