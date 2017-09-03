package gui.reversi.frame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.reversi.game.Reversi;

public class StandAloneReversiFrame extends Dialog implements IReversiFrame{

	private static final int BUTTON_SIZE = 75;
	private JButton[][] buttons;
	private JLabel label;
	private Reversi reversi; // 駒を置くときの処理関数を持ったReversiクラス型のフィールドreversi
	private String whitePlayerName;
	private String blackPlayerName;

	public StandAloneReversiFrame(Frame owner, String title, String whitePlayerName, String blackPlayerName) {
		super(owner, title);
		this.whitePlayerName = whitePlayerName;
		this.blackPlayerName = blackPlayerName;
		reversi = new Reversi(); // コンストラクタReversi()呼び出し
		
		// frameの設定
		this.setBounds(0, 0, 600, 700);
		this.setLayout(null);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setBackground(new Color(0, 100, 0));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});
		
		// ラベルの設定
		label = new JLabel();
		label.setBounds(0, BUTTON_SIZE * Reversi.BOARD_SIZE + 30, 500, 50);
		label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 26));
		this.add(label); // frameにラベルを追加

		// ボタンの設定
		buttons = new JButton[Reversi.BOARD_SIZE][Reversi.BOARD_SIZE];

		// 盤上をひとつずつ見ていくループ
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {

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
						reversi.putPiece(x, y);
						update();
					}
				});
				this.add(buttons[i][j]); // frameに追加
			}
		}
		update();
	}

	public void update() {
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
				// 盤上の位置情報を取得しframe上に反映させる
				int state = reversi.getStateAt(i, j);

				switch (state) {
				case Reversi.NONE:
					buttons[i][j].setText("");
					buttons[i][j].setBackground(new Color(0, 100, 0));
					break;

				case Reversi.BLACK:
					buttons[i][j].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 80));
					buttons[i][j].setBackground(new Color(0, 100, 0));
					buttons[i][j].setText("●");
					break;

				case Reversi.WHITE:
					buttons[i][j].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 80));
					buttons[i][j].setBackground(new Color(0, 100, 0));
					buttons[i][j].setText("○");
					break;
				}
			}
		}
		
		String text;
		// 現在のプレイヤーの色を取得してラベルに表示
		if (reversi.getCurrentColor() == Reversi.BLACK) {
			text = "●" + blackPlayerName + "さんの番です。";
		} else {
			text = "○" + whitePlayerName + "さんの番です。";
		}
		label.setText(text);
		
		if(reversi.isFinished()){
			FinishDialog finishDialog = new FinishDialog(this, "結果", reversi, blackPlayerName, whitePlayerName);
			finishDialog.setVisible(true);
		}

	}
}
