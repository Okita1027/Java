package pattern.structor.proxy.exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author qzy
 * @ClassName JdkProxy
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/18 9:32 星期二
 */
public class JdkProxy {
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置增强");
                Object invoke = method.invoke(object, args);
                System.out.println("后置增强");
                return invoke;
            }
        });
    }
}

/*class MyInnovationalHandler implements InvocationHandler {

    private final Object object;

    public MyInnovationalHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before增强");
        Object invoke = method.invoke(object, args);
        System.out.println("After增强");
        return invoke;
    }
}*/

interface Job {
    void findJob();

    void fun(String name);
}

class BOSSJob implements Job {
    @Override
    public void findJob() {
        System.out.println("Boss直聘");
    }

    @Override
    public void fun(String name) {
        System.out.println("fun" + name);
    }
}