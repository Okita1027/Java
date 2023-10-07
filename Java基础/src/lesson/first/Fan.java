package lesson.first;

/**
 * @author qzy
 * @time 2023/9/26 8:23 星期二
 * @title 风扇
 */
public class Fan {
    // 风扇速度常量
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed; // 风扇速度
    private boolean status; // 风扇是否打开
    private double radius; // 风扇半径
    private String color; // 风扇颜色

    // 无参构造方法，创建默认风扇
    public Fan() {
        speed = SLOW;
        status = false;
        radius = 5.0;
        color = "blue";
    }

    // 获取风扇速度
    public int getSpeed() {
        return speed;
    }

    // 设置风扇速度
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 获取风扇状态
    public boolean getStatus() {
        return status;
    }

    // 设置风扇状态
    public void setStatus(boolean status) {
        this.status = status;
    }

    // 获取风扇半径
    public double getRadius() {
        return radius;
    }

    // 设置风扇半径
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 获取风扇颜色
    public String getColor() {
        return color;
    }

    // 设置风扇颜色
    public void setColor(String color) {
        this.color = color;
    }

    // 返回描述风扇的字符串
    public String toString() {
        if (status) {
            return "Speed: " + speed + ", Color: " + color + ", Radius: " + radius;
        } else {
            return "Fan is off, Color: " + color + ", Radius: " + radius;
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setStatus(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        fan2.setStatus(false);

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());
    }
}
