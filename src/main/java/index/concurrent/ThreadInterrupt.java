package index.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by wangzhe.bj on 2017/10/20.
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new MyThread());
        t1.start();
        TimeUnit.SECONDS.sleep(1);

        t1.interrupt();

    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
