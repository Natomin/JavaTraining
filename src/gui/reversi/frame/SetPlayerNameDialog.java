package gui.reversi.frame;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetPlayerNameDialog extends Dialog {

	public SetPlayerNameDialog(Frame owner, String title) {
		super(owner, title);
		setLayout(null);
		setSize(370, 250);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// リソースの解放。×を押すとダイアログが閉じるように見える。
				dispose();
			}
		});

		JLabel bk = new JLabel("プレイヤー●の名前を入力してください");
		bk.setBounds(30, 30, 300, 30);
		this.add(bk);
		JTextField bkName = new JTextField(10);
		bkName.setBounds(30, 70, 300, 30);
		this.add(bkName);

		JLabel wh = new JLabel("プレイヤー○の名前を入力してください");
		wh.setBounds(30, 110, 300, 30);
		this.add(wh);
		JTextField whName = new JTextField(10);
		whName.setBounds(30, 150, 300, 30);
		this.add(whName);

		JButton ok = new JButton("OK");
		ok.setBounds(260, 200, 100, 30);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO 入力なしの判定
				
//				if("".equals(bk.getText()) || "".equals(wh.getText())){
//					JLabel errorMs = new JLabel("名前を入力してください");
//					errorMs.setForeground(Color.RED);
//				    JOptionPane.showMessageDialog(SetPlayerNameDialog.this, errorMs);
//				}else{
//					ReversiFrame frame = new ReversiFrame(wh.getText(), bk.getText());
//					frame.setVisible(true);
//				}
				ReversiFrame frame = new ReversiFrame(owner, "reversi", whName.getText(), bkName.getText());
				frame.setVisible(true);
				dispose();

			}
		});
		this.add(ok);

	}

}
