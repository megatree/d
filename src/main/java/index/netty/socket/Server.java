package index.netty.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangzhe.bj on 2018-11-28.
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口 " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("服务端启动失败");
        }

    }

    public void start() {
        //另起线程监听
        new Thread(() -> doStart()).start();
    }

    public void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("服务端doStart 异常");
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(9003);
        server.start();
    }
}
