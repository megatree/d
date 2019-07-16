package index.classloader;

/**
 * Created by wangzhe.bj on 2017/10/9.
 */
public class ClassLoadOrder {

    public static void main(String[] args) {
        B b= new B();

    }

    public static class A {

        public static A a3 = new A();

        public static int a = getA();

        public static int getA(){
            System.out.println("父类静态成员");
            return 1;

        }

        public int a2 = getA2();

        public int getA2(){
            System.out.println("父类非静态成员");
            return 2;
        }

        static {
            System.out.println("父类静态代码块");
        }

        {
            System.out.println("父类非静态代码块");
        }

        public A() {
            System.out.println("父类构造方法");
        }
    }

    public static class B extends A{

        static {
            System.out.println("子类静态代码块靠前");
        }

        public static int b = getB();

        public static int getB(){
            System.out.println("子类静态成员");
            return 1;

        }

        public int b2 = getB2();

        public int getB2(){
            System.out.println("子类非静态成员");
            return 2;
        }



        {
            System.out.println("子类非静态代码块");
        }

        public B() {
            System.out.println("子类构造方法");
        }
    }
}
