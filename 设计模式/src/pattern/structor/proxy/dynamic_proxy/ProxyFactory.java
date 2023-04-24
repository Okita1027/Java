package pattern.structor.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author qzy
 * @ClassName ProxyPoint
 * @Description JDK动态代理的增强对象必须要有接口
 * @Date 2022/12/20 12:59 星期二
 */
public class ProxyFactory {

    private final HouseSeller houseSeller = new HouseSeller();

    /*
        newProxyInstance()方法参数说明：
        ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
        Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
        InvocationHandler h ： 代理对象的调用处理程序
    */
    public Sell getProxy() {
        return (Sell) Proxy.newProxyInstance(houseSeller.getClass().getClassLoader(), houseSeller.getClass().getInterfaces(),
                /*
                    InvocationHandler中invoke方法参数说明：
                    proxy ： 代理对象
                    method ： 对应于在代理对象上调用的接口方法的 Method 实
                    例
                    args ： 代理对象调用接口方法时传递的实际参数
                */
                (proxy, method, args) -> {
            System.out.println("！增强！");
            return method.invoke(houseSeller, args);
        });
    }



    /*public static Object getProxy(Object object) {

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new MyInvocationHandler(object));
    }

    private static class MyInvocationHandler implements InvocationHandler{

        private final Object object;

        public MyInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("！ - 增强 - ！");
            return method.invoke(object, args);
        }
    }*/
}
