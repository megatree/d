package index.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wangzhe.bj on 2017/8/22.
 */
public class CGLibProxy implements MethodInterceptor {

    private Object delegate;


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before proxy");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("after proxy");
        return result;
    }

    public static <T> T getProxyInstance(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CGLibProxy());
        return (T) enhancer.create();
    }
}
