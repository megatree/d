package index.综合题系列1;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * Created by mythss on 2018-10-04.
 */
public class 循环打印abc {

    @Test
    public void test() throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();


        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock3) {
                    synchronized (lock1) {
                        System.out.println("a");

                        //唤醒其他竞争线程，也就是t2
                        lock1.notifyAll();
                    }
                    //同步块结束，t2拿到lock1

                    try {
                        lock3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("b");
                        lock2.notifyAll();
                    }
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    synchronized (lock3) {
                        System.out.println("c");
                        lock3.notifyAll();
                    }
                    try {
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(10);
        t2.start();
        Thread.sleep(10);
        t3.start();
        Thread.sleep(10);
    }


    @Test
    public void test2(){

    }

}
