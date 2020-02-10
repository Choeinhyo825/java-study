package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientReceiveThread extends Thread {

	private Socket socket;

	public ChatClientReceiveThread(Socket socket) {
		this.socket = socket;
	}

	// run 구현
	@Override
	public void run() {
		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while (true) {
				try {
					System.out.println(bufferedReader.readLine());
				} catch (Exception e) {
					System.out.println("종료되었습니다.");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
