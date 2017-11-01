package index.proxy;

/**
 * Created by wangzhe.bj on 2017/8/22.
 */
public class Test {

    public static void main(String[] args) {

//        IPerson person2 = (IPerson) new PersonProxy().iBind(IPerson.class);
//        person2.doSomething();

        IPerson person = (IPerson) new PersonProxy().bind(new Person());
        person.doSomething();

//        IAnimal animal = (IAnimal) new PersonProxy().bind(new Animal());
//        animal.run();
//
//        IAnimal animal2 = CGLibProxy.getProxyInstance(Animal.class);
//        animal2.run();


    }
}
