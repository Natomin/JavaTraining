package gui.reversi.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import gui.reversi.game.Reversi;
import gui.reversi.game.ReversiWrapper;

public class Client extends Thread {
	private Socket s;
	private OutputStream os;
	private InputStream is;
	private ReversiWrapper reversi;

	public Client(ReversiWrapper reversi) throws UnknownHostException, IOException {
		this.reversi = reversi;
		// ソケット生成
		s = new Socket("localhost", 8080);
	}

	public void run() {
		while (true) {
			System.out.println("client");
			try {
				is = s.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			} // クライアントから数値を受信
			DataInputStream dis = new DataInputStream(is);
			
			for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
				for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
					try {
						reversi.putPiece(i, j, dis.readInt());
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	public void write(){
		try {
			os = s.getOutputStream();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} // 送信
		DataOutputStream dos = new DataOutputStream(os);
		
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
				int state = reversi.getStateAt(i, j);
				try {
					dos.writeInt(state);
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}
}
