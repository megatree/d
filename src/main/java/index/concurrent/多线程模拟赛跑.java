package index.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhe.bj on 2017/11/30.
 */
public class 多线程模拟赛跑 {

    public static void main(String[] args) throws InterruptedException {
        race(10);

    }

    public static void race(int raceCount) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(raceCount);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(raceCount);

        for (int i = 0; i < raceCount; i++) {
            final int no = i + 1;
            new Thread(() -> {
                System.out.println(no + " 准备好了");
                ready.countDown();

                try {
                    start.await();
                    System.out.println(no + " 开始跑了");

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(no + " 到达终点");
                    end.countDown();
                }

            }).start();

        }

        ready.await();
        System.out.println("=====================都准备好了");
        System.out.println("=====================马上开跑");

        start.countDown();
        end.await();
        System.out.println("=====================都跑完了");

    }
}
