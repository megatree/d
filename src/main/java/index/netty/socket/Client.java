package index.netty.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhe.bj on 2018-11-28.
 */
public class Client {

    public static final String HOST       = "127.0.0.1";
    public static final int    PORT       = 9003;
    public static final int    SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(() -> {
            System.out.println("客户端启动成功");
            for (;;){
                String message = "hello,server...im client";
                System.out.println("客户端发送数据："+message);
                try {
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
