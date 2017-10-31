package index.threadlocaltest;

/**
 * Created by wangzhe.bj on 2017/10/12.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocalUtil.setSession("main");

        Runnable r1 = new Runnable() {

            private String name = "h1";
            private ThreadLocal threadLocal = new ThreadLocal();


            @Override
            public void run() {
                ThreadLocalUtil.setSession(name);
                threadLocal.set("456");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(ThreadLocalUtil.getSession());
                System.out.println(threadLocal.get());
            }
        };

        Runnable r2 = new Runnable() {

            private String name = "h2";
            private ThreadLocal threadLocal = new ThreadLocal();

            @Override
            public void run() {
                ThreadLocalUtil.setSession(name);
                threadLocal.set("789");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(ThreadLocalUtil.getSession());
                System.out.println(threadLocal.get());
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

        System.out.println(ThreadLocalUtil.getSession());

    }

}
