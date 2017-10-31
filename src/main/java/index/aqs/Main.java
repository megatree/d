package index.aqs;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangzhe.bj on 2017/9/28.
 */
public class Main{
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();

        a.await();
        b.await();
    }
}
