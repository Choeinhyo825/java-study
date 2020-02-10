package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) {

		Scanner sc = null;
		Socket socket = null;

		try {
			// 1.스케너 생성(표준입력, 키보드 연결)
			sc = new Scanner(System.in);

			// 2.소켓생성
			socket = new Socket();

			// 3.서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			log("connected...[PORT : " + SERVER_PORT + "]");

			// 4.IOStream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			while (true) {
				// 5.키보드 입력받기
				System.out.print(">>");
				String line = sc.nextLine();
				if ("quit".equals(line)) {
					break;
				}

				// 6.데이터 쓰기
				pw.println(line);

				// 7.데이터 읽기
				String data = br.readLine();
				if (data == null) {
					log("Closed by Server");
					break;
				}
				System.out.println("<<" + data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)
					sc.close();
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
