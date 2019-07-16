package index.concurrent;

import java.util.concurrent.TimeUnit;

public class MostPID {

    public static void main(String[] args) {

        new Thread(() -> {

            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {

            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
