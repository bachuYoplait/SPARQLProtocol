package test;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class TestRestAPI {

    public static void main(String[] args) throws Exception {
        ServerSocket sSocket = new ServerSocket(1000);

        System.out.println("접속 대기중~ ");


        Gson gson = new Gson();

        while (true) {
            Socket sock = sSocket.accept(); // 새로운 소켓을 생성 클라이언트가 들어왔을때 , 접속했을때  실행되는 구문
            if (sock != null) {
                byte[] byteArr = new byte[1000];

                System.out.println("사용자 접속 했습니다");
                System.out.println("Client ip :" + sock.getInetAddress());

                InputStream is = sock.getInputStream();

                //inputstream으로 request header를 확인
                int readByteCount = is.read(byteArr);
                String data = new String(byteArr, 0, readByteCount, "UTF-8");
                System.out.println(data);


                OutputStream ous = sock.getOutputStream();
                DataOutputStream dous = new DataOutputStream(ous);

                /**
                HTTP/1.1 200 OK
                Date: < some date >
                Content-Type: application/json
                Content-Length: < actual size >
                {"example":"data"}

                 프로토콜 규약에 맞춰서 DataOutputStream에 입력해줘야 Postman에서 정삭적으로 파싱이됨
                 **/

                dous.writeBytes("HTTP/1.1 200 OK\n" +
                        "Content-Type: application/json\n" +
                        "\n" +
                        "{\"example\":\"data\"}");
                dous.flush();
                ous.close();
                sock.close();
                break;
            }


        }


    }
}