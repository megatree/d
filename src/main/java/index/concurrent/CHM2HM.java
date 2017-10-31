package index.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap replaced by ConcurrentHashMap
 * Created by wangzhe.bj on 2017/7/21.
 */
public class CHM2HM {

    private static ConcurrentHashMap<String, Integer> map   = new ConcurrentHashMap<String, Integer>();
    private static String[]                           array = {"yy", "yy", "welcome", "java", "234", "java", "1234", "yy", "welcome", "java", "234"};

    public static void main(String[] args) {

        System.out.println("array size:" + array.length);
        for (String str : array) {
            new Thread(new MyTask(str)).start();
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    static class MyTask implements Runnable {
        String key;

        public MyTask(String key) {
            this.key = key;
        }

        @Override
        public void run() {
            Integer value = map.get(key);
            if (null == value) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }
    }

}
