package chat.client.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		new ChatClientReceiveThread(socket).start();
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 1. ui 초기화
		 * 
		 * 2. IOStream 초기화
		 * 
		 * 3. Thread 생성 작업
		 */
	}

	private void sendMessage() {

//		String message = textField.getText();
//		textField.setText("");
//		textField.requestFocus();
//		// 소켓을 통해 메세지가 온 경우...
//		textArea.append("둘리:" + message + "\n");

		try {
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String message = textField.getText();
//			String request =  + "\r\n";

			if ("quit".equals(message) == true) {
				// 8. quit 프로토콜 처리
				printWriter.println("quit");
				System.exit(0);
				// 9. 메세지 처리
			} else if (message.startsWith("to:") || message.startsWith("ban:")) {
				printWriter.println(message);
			} else {
				printWriter.println("message:" + message);
			}

			textField.setText("");
			textField.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ChatClientReceiveThread extends Thread {

		Socket socket = null;

		ChatClientReceiveThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {
					String msg = br.readLine();
					if (msg == null) {
						textArea.append(" ");
					}
					if("ban".equals(msg)) {
						System.exit(0);
					}
					textArea.append(msg);
					textArea.append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
