package pattern.structor.proxy.exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author qzy
 * @ClassName ProxyFactory
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/18 10:43 星期二
 */
public class ProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理站点收取代理服务费");
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
    }
}
