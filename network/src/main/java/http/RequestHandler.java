package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			// get IOStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			OutputStream outputStream = socket.getOutputStream();

			String request = null;
			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끈음
				if (line == null) {
					break;
				}
				// Request(요청)의 헤더만 읽음
				if ("".equals(line)) {
					break;
				}
				// 헤더의 첫번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
			}

			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				consoleLog(request);
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				// [POST, DELETE, PUT], HEAD, CONNECT
				response400Error(outputStream, tokens[2]);

			}
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResource(OutputStream os, String uri, String protocol) throws IOException {
		if ("/".equals(uri)) {
			uri = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + uri);
		if (!file.exists()) {
			// 404응답 하기 과제
			response404Error(os, protocol);
			return;
		}
		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		// 응답
		os.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	private void response404Error(OutputStream os, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + "/error/404.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		os.write((protocol + " 404 NotFound\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	private void response400Error(OutputStream os, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + "/error/400.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		os.write((protocol + " 400 Bad Request\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
