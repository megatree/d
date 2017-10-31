package index.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangzhe.bj on 2017/8/22.
 */
public class PersonProxy implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    public Object iBind(Class mapperInterface){
//        this.delegate = this;
        return Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before proxy");
//        result = method.invoke(delegate, args);
        result = method.invoke(this, args);
        System.out.println("after proxy");
        return result;
    }


}
