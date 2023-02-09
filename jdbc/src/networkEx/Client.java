package networkEx;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("클라이언트가 접속되었습니다.");
		// 서버접속
//		Socket socket=new Socket("192.168.0.23",4000);
		Socket socket = new Socket("localhost", 4000);
		// Server에 보낼 데이터
		BufferedWriter bufWriter = null;
		BufferedReader bufReader = null;

		try {
			while (true) {
				// Server에 보낼 데이터를 담는 객체 생성
				bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				Scanner sc = new Scanner(System.in);
				System.out.println("[클라이언트 메세지] : ");
				String str = sc.nextLine();
				bufWriter.write(str);
				bufWriter.newLine();
				// 서버로 데이터 전송 (버퍼 강제 비움)
				bufWriter.flush();

				// Server가 보낸 데이터를 담는 객체 생성
				bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String message = bufReader.readLine();
				System.out.println("서버Message : " + message);
				if (message.contains("종료")) {
					str = "종료";
					bufWriter.write(str);
					bufWriter.newLine();
					bufWriter.flush();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
			bufReader.close();
			bufWriter.close();
		}
	}
}
