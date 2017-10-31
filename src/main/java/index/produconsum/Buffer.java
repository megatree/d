package index.produconsum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangzhe.bj on 2017/7/20.
 */
public class Buffer {

    static  Buffer    buf      = new Buffer();
    private Lock      lock     = new ReentrantLock();
    private Condition notFull  = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int buffer;
    private int maxCount = 30;

    public static void main(String[] args) {


        Runnable add = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(200);
                        buf.produce();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable remove = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(300);
                        buf.consume();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(add);
        executorService.submit(remove);
        executorService.shutdown();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void produce() {
        try {
            lock.lockInterruptibly();
            while (buffer == maxCount) {
                notFull.await();
            }
            buffer++;
            notEmpty.signal();
            System.out.println("Produce: buffer->" + buffer + " thread->" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lockInterruptibly();
            while (buffer == 0) {
                notEmpty.await();
            }
            buffer--;
            notFull.signal();
            System.out.println("Consume: buffer->" + buffer + " thread->" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
