package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			// 1. 서버소켓 생성
			ss = new ServerSocket();

			// 2. 바인딩 : Socket Address(IP Address + Port) Binding
			ss.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Sertver Stats...[port:" + PORT + "]");

			while (true) {
				// 3. accept
				Socket socket = ss.accept();// blocking 연결을 대기함

				new EchoServerRecieveThread(socket).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null)
					ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[Server#" + Thread.currentThread().getId() + "] " + log);
	}

}
