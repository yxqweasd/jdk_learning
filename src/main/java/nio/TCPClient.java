package nio;

/**
 * Created by huangweinan on 2019/5/22.
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TCPClient {

    // 通道选择器，用于管理客户端的通道
    private Selector selector;

    // 与服务器通信的通道
    SocketChannel socketChannel;

    // 要连接的服务器的IP
    private String hostIp;

    // 要连接的远程服务器在监听的端口
    private int hostListenningPort;

    static TCPClient client;

    static boolean mFlag = true;

    public TCPClient(String hostIp, int hostPort) throws IOException {
        this.hostIp = hostIp;
        this.hostListenningPort = hostPort;
        init();
    }

    private void init() throws IOException {
        // 打开监听通道
        socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
        socketChannel.configureBlocking(false);

        // 创建选择器，并把通道注册到选择器中
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);

        new TCPClientReadThread(selector);
    }

    /**
     * 发送字符串到服务器
     *
     * @param message
     * @throws IOException
     */
    public void sendMsg(String message) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
        socketChannel.write(writeBuffer);
    }

    public static void main(String[] args) throws IOException {
        client = new TCPClient("127.0.0.1", 1993);
        new Thread() {
            @Override
            public void run() {
                try {
                    client.sendMsg("test----~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    while (mFlag) {
                        Scanner scan = new Scanner(System.in);
                        String string = scan.next();
                        client.sendMsg(string);
                    }
                } catch (Exception e) {
                    mFlag = false;
                } finally {
                    mFlag = false;
                }
                super.run();
            }
        }.start();
    }


    static class TCPClientReadThread implements Runnable {
        private Selector selector;

        public TCPClientReadThread(Selector selector) {
            super();
            this.selector = selector;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                while (selector.select() > 0) {// select()方法只能使用一次，用了之后就会自动删除,每个连接到服务器的选择器都是独立的
                    // 遍历每个有IO操作Channel对应的SelectionKey
                    for (SelectionKey sk : selector.selectedKeys()) {
                        if (sk.isReadable()) {
                            // 使用NIO读取Channel中的数据
                            SocketChannel sc = (SocketChannel) sk.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            sc.read(buffer);
                            buffer.flip();
                            String receivedString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
                            System.out.println("接收到来自服务器：" + sc.socket().getRemoteSocketAddress() + "的信息：" + receivedString);
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                        selector.selectedKeys().remove(sk);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


