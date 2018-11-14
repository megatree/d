package index.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhe.bj on 2018-10-26.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("都会执行的内容 "+ Thread.currentThread().getName());
        });

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            es.submit(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + " 进入");
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(4) * 1000 + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + " 到达终点,等待其他线程");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + " 从等待中恢复");
                try {
                    Thread.sleep(5 * 1000 + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + " 结束");


            });
        }
        es.shutdown();

    }
}
