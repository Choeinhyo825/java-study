package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket s = null;
		try {
			// 1.소켓생성
			s = new Socket();

			// 1-1 소켓버퍼 사이즈 확인
			int receiveBufferSize = s.getReceiveBufferSize();
			int sendBufferSize = s.getSendBufferSize();
			System.out.println(receiveBufferSize + " : " + sendBufferSize);

			// 1-2 소켓버퍼 사이즈 벼경
			s.setReceiveBufferSize(1024 * 10);
			s.setSendBufferSize(1024 * 10);

			// 1-3 SO_NODELAY(Nagel Algorithm Off)
			s.setTcpNoDelay(true);

			// 1-4 SO_TIMEOUT
			s.setSoTimeout(1000); // 1초만 읽고 나옴 1초안에 데이터가 안오면 excption발생

			// 2.서버연결
			s.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			System.out.println("[client]connected");

			// 3.IOStream 받아오기
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();

			// 4.쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));

			// 5.읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer); // blocking 대기함
			if (readByteCount == -1) {
				// server에서 정상종료
				System.out.println("close by server");
				return;
			}
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client]receied : " + data);
		} catch (SocketTimeoutException e) {
			System.out.println("[client]TimeOut");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null && !s.isClosed())
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
