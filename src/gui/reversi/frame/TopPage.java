package gui.reversi.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TopPage extends JFrame {
	private String title = "Reversi Game";

	public TopPage() {
		// frameの設定
		this.setBounds(50, 50, 500, 550);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TitleLabelの設定
		JLabel label = new JLabel();
		label.setBounds(50, 0, 300, 100);
		label.setText(title);
		label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 42));
		this.add(label);
		// Iconの設定
		ImageIcon icon = new ImageIcon("./src/gui/reversi/frame/othello_game.png");
		JLabel imegeLabel = new JLabel(icon);
		imegeLabel.setBounds(0, 0, 500, 500);
		this.add(imegeLabel);
		// Buttonの設定
		JButton standalonePlay = new JButton("このPCであそぶ");
		standalonePlay.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
		standalonePlay.setBounds(30, 450, 200, 50);
		standalonePlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 表示するダイアログの設定
				SetPlayerNameDialog playerNameDialog = new SetPlayerNameDialog(TopPage.this, "プレイヤー名の設定");
				playerNameDialog.setVisible(true);
			}
		});
		this.add(standalonePlay);

		JButton connectPlay = new JButton("遠隔通信であそぶ");
		connectPlay.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
		connectPlay.setBounds(270, 450, 200, 50);
		this.add(connectPlay);

	}

}