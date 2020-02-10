package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			// 1. 서버소켓 생성
			ss = new ServerSocket();

			// 1-1 Time-Wait 시간에 소켓에 포트번호 할당을 가능하게 하기 위해서
			ss.setReuseAddress(true);

			// 2. 바인딩 : Socket Address(IP Address + Port) Binding
			ss.bind(new InetSocketAddress("127.0.0.1", 5000));

			// 3. accept
			Socket socket = ss.accept();// blocking 연결을 대기함
			// ipAddress랑 port를 알아낼수 있음
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();

			System.out.println("[server]connected by client[" + remoteHostAddress + " : " + remotePort + "]");

			try {

				// 4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking 대기함
					if (readByteCount == -1) {
						// client에서 정상종료 -> close() 호출
						System.out.println("[server]close by client");
						break;
					}
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server]received : " + data);

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// 6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
			} catch (SocketException e) {
				System.out.println("[server]sudden closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed())
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
}
