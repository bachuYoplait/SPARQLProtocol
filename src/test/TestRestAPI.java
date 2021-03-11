package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestRestAPI {

    public static void main(String[] args) throws Exception {

        ServerSocket sSocket = new ServerSocket(1000);

        System.out.println("접속 대기중~ ");

        while (true) {
            Socket sock = sSocket.accept(); // 새로운 소켓을 생성 클라이언트가 들어왔을때 , 접속했을때  실행되는 구문
            if (sock != null) {
                System.out.println("사용자 접속 했습니다");
                System.out.println("Client ip :" + sock.getInetAddress());

                OutputStream ous = sock.getOutputStream();
                DataOutputStream dous = new DataOutputStream(ous);

                dous.writeInt(200);
                dous.flush();
                dous.close();
                sock.close();
                break;
            }


        }


    }
}