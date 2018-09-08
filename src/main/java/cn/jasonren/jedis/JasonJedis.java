package cn.jasonren.jedis;

import java.io.IOException;
import java.net.Socket;


/**
 * 手写jedis
 */
public class JasonJedis {
    public static String ip = "127.0.0.1";
    public static int port = 6379;

    /**
     * *3
     * $3
     * SET
     * $11
     * lisonLength
     * $2
     * 10
     */
    public static String set(Socket socket, String key, String value) throws IOException {
        //resp set key value发出去
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("*3").append("\r\n");
        stringBuffer.append("$3").append("\r\n");
        stringBuffer.append("SET").append("\r\n");
        stringBuffer.append("$").append(key.getBytes().length).append("\r\n"); //防止中文getBytes
        stringBuffer.append(key).append("\r\n");
        stringBuffer.append("$").append(value.getBytes().length).append("\r\n");
        stringBuffer.append(value).append("\r\n");

        socket.getOutputStream().write(stringBuffer.toString().getBytes());

        byte[] response = new byte[2048];
        socket.getInputStream().read(response);
        return new String(response);

    }

    /**
     * *2
     * $3
     * GET
     * $11
     * lisonLength
     */
    public static String get(Socket socket, String key) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("*2").append("\r\n");
        stringBuffer.append("$3").append("\r\n");
        stringBuffer.append("GET").append("\r\n");
        stringBuffer.append("$").append(key.getBytes().length).append("\r\n"); //防止中文getBytes
        stringBuffer.append(key).append("\r\n");

        socket.getOutputStream().write(stringBuffer.toString().getBytes());

        byte[] response = new byte[2048];
        socket.getInputStream().read(response);
        return new String(response);
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip, port);
        set(socket, "name", "james");
        System.out.println(get(socket, "name"));

    }
}
