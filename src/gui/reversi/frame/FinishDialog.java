package gui.reversi.frame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import gui.reversi.game.Reversi;
import gui.reversi.game.ReversiWrapper;

public class FinishDialog extends Dialog {
	private int whitePieceNum = 0;
	private int blackPieceNum = 0;
	

	public FinishDialog(Dialog owner, String title, Reversi reversi, String blackPlayerName, String whitePlayerName) {
		super(owner, title);
		countAll(reversi);
		setLayout(null);
		setSize(370, 150);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});
		JLabel result = new JLabel();
		if(whitePieceNum > blackPieceNum){
			result.setText(whitePieceNum + "対" + blackPieceNum + "で" + whitePlayerName + "さんの勝ちです！");
		}else if(blackPieceNum > whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + blackPlayerName + "さんの勝ちです！");
		}else if(blackPieceNum == whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + "引き分けです！");
		}
		result.setBounds(30, 70, 300, 30);
		this.add(result);
		
	}
	
	public FinishDialog(ServerReversiFrame owner, String title, ReversiWrapper reversi, String blackPlayerName,
			String whitePlayerName) {
		super(owner, title);
		countAll(reversi);
		setLayout(null);
		setSize(370, 150);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});
		JLabel result = new JLabel();
		if(whitePieceNum > blackPieceNum){
			result.setText(whitePieceNum + "対" + blackPieceNum + "で" + whitePlayerName + "さんの勝ちです！");
		}else if(blackPieceNum > whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + blackPlayerName + "さんの勝ちです！");
		}else if(blackPieceNum == whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + "引き分けです！");
		}
		result.setBounds(30, 70, 300, 30);
		this.add(result);
	}

	public FinishDialog(ClientReversiFrame owner, String title, ReversiWrapper reversi, String blackPlayerName,
			String whitePlayerName) {
		super(owner, title);
		countAll(reversi);
		setLayout(null);
		setSize(370, 150);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});
		JLabel result = new JLabel();
		if(whitePieceNum > blackPieceNum){
			result.setText(whitePieceNum + "対" + blackPieceNum + "で" + whitePlayerName + "さんの勝ちです！");
		}else if(blackPieceNum > whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + blackPlayerName + "さんの勝ちです！");
		}else if(blackPieceNum == whitePieceNum){
			result.setText(blackPieceNum + "対" + whitePieceNum + "で" + "引き分けです！");
		}
		result.setBounds(30, 70, 300, 30);
		this.add(result);
	}
	private void countAll(ReversiWrapper reversi) {
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
				// 盤上の色情報を取得しカウントする
				int state = reversi.getStateAt(i, j);

				switch (state) {
				case Reversi.BLACK:
					blackPieceNum++;
					break;

				case Reversi.WHITE:
					whitePieceNum++;
					break;
				}
			}
		}
	}

	private void countAll(Reversi reversi){
		for (int i = 0; i < Reversi.BOARD_SIZE; i++) {
			for (int j = 0; j < Reversi.BOARD_SIZE; j++) {
				// 盤上の色情報を取得しカウントする
				int state = reversi.getStateAt(i, j);

				switch (state) {
				case Reversi.BLACK:
					blackPieceNum++;
					break;

				case Reversi.WHITE:
					whitePieceNum++;
					break;
				}
			}
		}
	}

}
