package principle.迪米特;

/**
 * @version v1.0
 * @ClassName: Fans
 * @Description: 粉丝类
 * @Author: 黑马程序员
 */
public class Fans {

    private String name;

    public String getName() {
        return name;
    }

    public Fans(String name) {
        this.name = name;
    }
}
