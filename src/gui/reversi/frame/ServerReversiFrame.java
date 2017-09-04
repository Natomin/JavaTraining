package gui.reversi.frame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.reversi.clock.UpdateClockThread;
import gui.reversi.game.ReversiWrapper;
import gui.reversi.socket.Server;

public class ServerReversiFrame extends Dialog implements IReversiFrame {

	private static final int BUTTON_SIZE = 75;
	private JButton[][] buttons;
	private JLabel label;
	private ReversiWrapper reversi; // 駒を置くときの処理関数を持ったReversiクラス型のフィールドreversi
	private Server server;
	private UpdateThread updateThread;
	private JLabel clock;

	public ServerReversiFrame(Frame owner, String title, String ip) {
		super(owner, title);
		reversi = new ReversiWrapper(); // コンストラクタReversi()呼び出し
		reversi.setCurrentColor(ReversiWrapper.WHITE);

		// frameの設定
		this.setBounds(0, 0, 600, 700);
		this.setLayout(null);
		this.setResizable(false);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setBackground(new Color(0, 100, 0));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});

		// 時計の設定
		clock = new JLabel("");
		clock.setBounds(500, BUTTON_SIZE * ReversiWrapper.BOARD_SIZE + 30, 100, 50);
		this.add(clock);

		// ラベルの設定
		label = new JLabel();
		label.setBounds(0, BUTTON_SIZE * ReversiWrapper.BOARD_SIZE + 30, 500, 50);
		label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 26));
		this.add(label); // frameにラベルを追加

		// ボタンの設定
		buttons = new JButton[ReversiWrapper.BOARD_SIZE][ReversiWrapper.BOARD_SIZE];

		// 盤上をひとつずつ見ていくループ
		for (int i = 0; i < ReversiWrapper.BOARD_SIZE; i++) {
			for (int j = 0; j < ReversiWrapper.BOARD_SIZE; j++) {

				final int x = i;
				final int y = j;

				// 64個のボタンを生成
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(new Color(0, 100, 0));
				buttons[i][j].setBounds(i * BUTTON_SIZE, j * BUTTON_SIZE + 25, BUTTON_SIZE, BUTTON_SIZE);
				// buttonsがActionEventを受け取れるようにする(addActionListnerメソッドを実行)
				// 引数はActionListner
				buttons[i][j].addActionListener(new ActionListener() {

					// Eventが発生するとActionListner(インタフェース)がactionPerformed(メソッド)を呼ぶ
					@Override
					public void actionPerformed(ActionEvent e) {
						// Event発生(Bottonsが押されたとき)の処理
						reversi.putPiece(x, y, ReversiWrapper.BLACK);
						update();
						try {
							server.write();
						} catch (IOException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					}
				});
				this.add(buttons[i][j]); // frameに追加
			}
		}
		update();
		try {
			server = new Server(reversi, ip);
			server.start();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		updateThread = new UpdateThread(this);
		updateThread.start();
		new UpdateClockThread(this).start();
	}

	public void update() {
		for (int i = 0; i < ReversiWrapper.BOARD_SIZE; i++) {
			for (int j = 0; j < ReversiWrapper.BOARD_SIZE; j++) {
				// 盤上の位置情報を取得しframe上に反映させる
				int state = reversi.getStateAt(i, j);

				switch (state) {
				case ReversiWrapper.NONE:
					buttons[i][j].setText("");
					buttons[i][j].setBackground(new Color(0, 100, 0));
					break;

				case ReversiWrapper.BLACK:
					buttons[i][j].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 80));
					buttons[i][j].setBackground(new Color(0, 100, 0));
					buttons[i][j].setText("●");
					break;

				case ReversiWrapper.WHITE:
					buttons[i][j].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 80));
					buttons[i][j].setBackground(new Color(0, 100, 0));
					buttons[i][j].setText("○");
					break;
				}
			}
		}

		String text;
		// 現在のプレイヤーの色を取得してラベルに表示
		if (reversi.getCurrentColor() == ReversiWrapper.BLACK) {
			text = "●" + "の番です。";
		} else {
			text = "○" + "の番です。";
		}
		label.setText(text);

		if (reversi.isFinished()) {
			FinishDialog finishDialog = new FinishDialog(this, "結果", reversi, "", "");
			updateThread.stopRunning();
			finishDialog.setVisible(true);
		}
	}

	public void updateTime(String time) {
		clock.setText(time);
	}

}
