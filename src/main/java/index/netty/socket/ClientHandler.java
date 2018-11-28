package index.netty.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by wangzhe.bj on 2018-11-28.
 */
public class ClientHandler {

    private static final int    MAX_DATA_LEN = 5;
    private final        Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        System.out.println("新客户端接入");
        new Thread(() -> doStart()).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            for (; ; ) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息：" + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
