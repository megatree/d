package index.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangzhe.bj on 2017/7/17.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> c1 = Class.forName("index.classloader.Person", true, mcl);
        Constructor c=c1.getConstructor(int.class,String.class);
        Object obj = c.newInstance(11,"tom");
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        System.out.println("------------------------------------------");
        MyClassLoader mc2 = new MyClassLoader(mcl);
        Class<?> c2 = Class.forName("index.classloader.Person", true, mc2);
        Constructor d=c2.getConstructor(int.class,String.class);
        Object obj2 = d.newInstance(11,"tom");
        System.out.println(obj2);
        System.out.println(obj2.getClass().getClassLoader());


    }

    public int a = 1;

    public static Main inst;

    public static void test(){

    }
}
