package index.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangzhe.bj on 2017/7/19.
 */
public class SyncTest {

    public static void main(String[] args) {
        SubKlazz subKlazz = new SubKlazz();
        subKlazz.get();
    }


    public static class Klazz {
        Lock lock = new ReentrantLock();

        public int get() {
            try {
                lock.lockInterruptibly();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return 2;
        }
    }

    public static class SubKlazz extends Klazz {
        Lock lock = new ReentrantLock();

        public int get() {
            try {
                lock.lockInterruptibly();
                super.get();
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return 3;
        }
    }
}
