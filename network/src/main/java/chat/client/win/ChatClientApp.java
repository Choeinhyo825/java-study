package chat.client.win;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {

	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		// 1.socket생성
		Socket socket = new Socket();
		try {
			// 2.connetct to server
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("채팅방에 입장하셨습니다.");
			new ChatWindow(name, socket).show();

			// 3.IOStream 생성
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 4.join 프로토콜 요청 및 처리
			printWriter.println("join:" + name);

			// 5.join프로토콜이 성공응답을 받으면
//			printWriter.println("join:ok");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
