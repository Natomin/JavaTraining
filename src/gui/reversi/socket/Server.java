package gui.reversi.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import gui.reversi.game.Reversi;
import gui.reversi.game.ReversiWrapper;

public class Server extends Thread {
	private ServerSocket ss;
	private InputStream is;
	private DataInputStream dis;
	private Socket s;
	private ReversiWrapper reversi;

	public Server(ReversiWrapper reversi) throws IOException {
		this.reversi = reversi;
		// ソケットを生成＆待機
		ss = new ServerSocket();
		ss.bind(new InetSocketAddress("localhost", 8080));
		s = ss.accept();
	}

	public void run() {
		while (true) {
			try {
				is = s.getInputStream(); // クライアントから数値を受信
				dis = new DataInputStream(is);
				
				for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
					for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
						reversi.putPiece(i, j, dis.readInt());
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void write() throws IOException{
		OutputStream os = s.getOutputStream(); // 送信
		DataOutputStream dos = new DataOutputStream(os);
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
				int state = reversi.getStateAt(i, j);
				dos.writeInt(state);
			}
		}
	}
}
