package index.concurrent;

import java.util.concurrent.*;

/**
 * Created by wangzhe.bj on 2017/9/11.
 */
public class ThreadPool {

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "123";
            }
        };

        FutureTask<String> futureTask = new FutureTask<String>(callable);

        ExecutorService executorService = Executors.newWorkStealingPool(4);
//        Future<String> future = executorService.submit(callable);
        executorService.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
