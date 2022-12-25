package reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @time 2022/5/7 17:54 星期六
 * 动态代理
 */

interface Act {
    String exercise();

    void eat(String food);
}

//被代理类
class Human implements Act{

    @Override
    public String exercise() {
        return "游泳";
    }

    @Override
    public void eat(String food) {
        System.out.println("我爱吃" + food);
    }
}

/*
要想实现动态代理，斋要解决的问题?
问题一:如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二:当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法、
* */

class ProxyFactory {
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj) { //obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类的对象进行赋值

    //实例化
    public void bind(Object obj) {
        this.obj = obj;
    }
    //当通过代理类的对象，调用方法a时，就会自动调用invoke()方法
    //将被代理类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行动态代理增强原有方法！");
        //method即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中的invoke()的返回值
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Human human = new Human();
        //proxyInstance:代理类的对象
        Act proxyInstance = (Act) ProxyFactory.getProxyInstance(human);
        //当通过代理类对象调用方法时，会自动地调用被代理类中同名的方法
        System.out.println(proxyInstance.exercise());
        proxyInstance.eat("草莓");
    }
}
