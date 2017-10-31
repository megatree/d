package index.concurrent;

import java.util.concurrent.*;

/**
 * Created by wangzhe.bj on 2017/7/20.
 */
public class Main {

    private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);



    }

    private static void kickOffEntry(final int index) {
        executor.submit((Callable<Void>) () -> {
                    System.out.println("start " + index);
                    Thread.sleep(1000); // pretend to do work
                    System.out.println("stop " + index);
                    return null;
                }
        );
    }

    public static class REH implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    }

}
