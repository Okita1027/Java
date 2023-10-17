package lesson.homework;

/**
 * @author qzy
 * @time 2023/10/16 16:04 星期一
 * @title  设计一个台灯类(Lamp)其中台灯有灯泡类(Buble)这个属性，在构造方法中给该属性赋值，还有开灯(on)这个方法。设计一个灯泡类(Buble)，灯泡类有发亮的方法，其中有红灯泡类(RedBuble)和绿灯泡类(GreenBuble)。他们都继承灯泡类(Buble)一个发亮的方法，在测试类Test中测试，实现点亮红灯泡。
 */
public class Exercise2 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp(new RedBuble());
        lamp.on();
    }
}

class Lamp {
    private Buble buble;

    public Lamp(Buble buble) {
        this.buble = buble;
    }

    public void on() {
        buble.lighting();
    }
}

abstract class Buble {
    protected abstract void lighting();
}
class RedBuble extends Buble {

    @Override
    protected void lighting() {
        System.out.print("红色灯泡发亮");
    }
}
class GreenBuble extends Buble {

    @Override
    protected void lighting() {
        System.out.print("绿色灯泡发亮");
    }
}