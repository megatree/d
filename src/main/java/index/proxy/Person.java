package index.proxy;

/**
 * Created by wangzhe.bj on 2017/8/22.
 */
public class Person implements IPerson {
    @Override
    public void doSomething() {
        System.out.println("a man did something");
    }
}
