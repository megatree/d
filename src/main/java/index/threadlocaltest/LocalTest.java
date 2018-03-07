package index.threadlocaltest;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LocalTest {


    // (1)
    final static         ThreadPoolExecutor         poolExecutor  = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    // (2)
    private ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        LocalTest localTest = new LocalTest();
        localTest.testLocal();
    }

    public void testLocal() throws InterruptedException {
        // (3)
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(() -> {
                // (4)
                localVariable.set(new LocalVariable());
                // (5)
                System.out.println("use local varaible");
                //有这行内存不会回收
                localVariable.remove();

            });

            Thread.sleep(1000);
        }
        // (6)
        Thread.sleep(3600000);

        System.out.println("pool execute over");
    }

    static class LocalVariable {

        private Long[] a = new Long[1024 * 1024];
    }
}
