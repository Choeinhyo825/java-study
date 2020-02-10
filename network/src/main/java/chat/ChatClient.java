package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			log("connected...[PORT : " + SERVER_PORT + "]");
			// 4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();

//			while(true) {
//				boolean checkName = ChatServerThread.checkName(nickname);
//			}

			printWriter.println("join:" + nickname);
//			printWriter.flush();

			// 6. ChatClientReceiveThread 시작
			new ChatClientReceiveThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					printWriter.println("quit");
					break;
					// 9. 메세지 처리
				} else if (input.startsWith("to:") || input.startsWith("ban:")) {
					printWriter.println(input);
				} else {
					printWriter.println("message:" + nickname + ":" +  input);
				}
//				if ("quit".equals(input) == true) {
//					// 8. quit 프로토콜 처리
//					printWriter.println("quit");
//					break;
//					// 9. 메세지 처리
//				} else if (input.startsWith("to:")) {
//					printWriter.println("to:" + input);
//				} else if (input.equals("leader")) {
//					printWriter.println(input + ":");
//				} else if (input.startsWith("lv")) {
//					printWriter.println("lv:" + input);
//				} else {
//					printWriter.println("message:" + nickname + ":" + input);
//				}

			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			try {
				if (scanner != null)
					scanner.close();
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[Client] " + log);
	}

}
