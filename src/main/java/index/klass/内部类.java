package index.klass;

/**
 * Created by wangzhe.bj on 2018/3/14.
 */
public class 内部类 {


    public static void main(String[] args) {
        try {
            Test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Test() throws InterruptedException {
        System.out.println("Start of program.");

        ClassOuter outer = new ClassOuter();
        Object object = outer.object;
        outer = null;

        System.out.println("Execute GC");
        System.gc();

        Thread.sleep(3000);
        System.out.println("End of program.");
    }

    public static class ClassOuter {

        Object object = new Object() {
            @Override
            public void finalize() {
                System.out.println("inner Free the occupied memory...");
            }
        };

        @Override
        public void finalize() {
            System.out.println("Outer Free the occupied memory...");
        }
    }

}