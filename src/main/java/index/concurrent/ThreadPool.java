package index.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangzhe.bj on 2017/9/11.
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(10, 20,
                3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                new MyDefaultThreadFactory(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t.getName() + " 抛出了异常:" + e.getMessage());
                    }
                }),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });
        es.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 30; i++) {
            final int k = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
//                    if (k % 10 == 3) {
//                        throw new RuntimeException(k + "  im fucked ");
//                    }
//                    System.out.println(String.format("%s  %s", String.valueOf(k), Thread.currentThread().getName()));

                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


        for(;;){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("poolSize:%s",es.getPoolSize()));
        }


//        es.shutdown();

    }

    public static class MyDefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String                          namePrefix;
        private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

        MyDefaultThreadFactory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            t.setUncaughtExceptionHandler(this.uncaughtExceptionHandler);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }


}
