package index.综合题系列1;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhe.bj on 2018/3/5.
 */
public class 生产者消费者模式 {

    public static void main(String[] args) {
        Storage storage = new Storage();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            es.submit(new Producer(storage));
            es.submit(new Consumer(storage));
        }
        es.shutdown();
    }

    public static class Storage{

        private final Object lock = new Object();
        private final LinkedList<String> list = new LinkedList<>();
        private int maxSize = 10;

        public void produce(String str){
            synchronized (lock){
                while (list.size()>=10){
                    System.out.println("仓库满了");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }

                list.add(str);
                System.out.println(String.format("生产了货物 %s，当前容量 %s",str,list.size()));
                lock.notifyAll();
            }

        }

        public void consume(){
            synchronized (lock){
                while (list.size()==0){
                    System.out.println("仓库空了");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String str = list.removeFirst();
                System.out.println(String.format("消费了货物 %s，当前容量 %s",str,list.size()));
                lock.notifyAll();
            }
        }

    }

    public static class Producer implements Runnable{

        private Storage storage;

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            storage.produce("pro-"+System.currentTimeMillis()/1000);
        }
    }

    public static class Consumer implements Runnable{

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            storage.consume();
        }
    }
}
