package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerRecieveThread extends Thread {
	private Socket socket = null;

	public EchoServerRecieveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteInetAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		EchoServer.log("connected by client[" + remoteInetAddress + " : " + remotePort + "]");

		try {

			// 4. IOStream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			// 원래는 buffer가 꽉차야 보내주거나 집적 fulsh()로 보내지만 true옵션은 입력이 들어오는 즉시 flush()를 해줌

			while (true) {
				// 5. 데이터 읽기
				String data = br.readLine(); // blocking 대기함
				if (data == null) {
					// client에서 정상종료 -> close() 호출
					EchoServer.log("close by client");
					break;
				}
				EchoServer.log("received : " + data);

				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			EchoServer.log("suddenly closed by client");
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
	}

}
