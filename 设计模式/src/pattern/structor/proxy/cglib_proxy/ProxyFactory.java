package pattern.structor.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author qzy
 * @ClassName ProxyFactory
 * @Description CGlib动态代理，基于继承关系实现
 * @Date 2022/12/20 14:32 星期二
 */
public class ProxyFactory implements MethodInterceptor {

    private JobHelper target = new JobHelper();

    public JobHelper getProxy() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        return (JobHelper) enhancer.create();
    }

    /*
            intercept方法参数说明：
            o ： 代理对象
            method ： 真实对象中的方法的Method实例
            args ： 实际参数
            methodProxy ：代理对象中的方法的method实例
        */
    @Override
    public JobHelper intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("已经增强（CGLib）！");
        return (JobHelper) methodProxy.invoke(o, objects);
    }
}
