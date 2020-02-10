package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		Map<String, Object> map = new HashMap<String, Object>();
		// bind(포트, 5)?

		// 1. 서버 소겟 생성
		try {
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 5);
			log("연결 기다림 " + hostAddress + ":" + PORT);

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters, map).start();
			}
		} catch (IOException e) {
			System.out.println("Server Exception : " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[Server] : " + log);
	}

}
