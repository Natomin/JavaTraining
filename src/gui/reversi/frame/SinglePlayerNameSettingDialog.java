package gui.reversi.frame;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SinglePlayerNameSettingDialog extends Dialog {
	public boolean isCheckingServer = true;
	private JLabel nameLabel;
	private JTextField playerName;
	private JButton ok;
	private JCheckBox serverCheckbox;
	private JCheckBox clientCheckbox;
	
	public SinglePlayerNameSettingDialog(Frame owner, String title) {
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
		serverCheckbox = new JCheckBox("server", isCheckingServer);
		clientCheckbox = new JCheckBox("client", !isCheckingServer);
		serverCheckbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isCheckingServer = true;
				clientCheckbox.setSelected(false);
				updateLabel();
			}
		});
		serverCheckbox.setBounds(30, 30, 150, 30);
		this.add(serverCheckbox);
		
		clientCheckbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isCheckingServer = false;
				serverCheckbox.setSelected(false);
				updateLabel();
			}
		});
		clientCheckbox.setBounds(180, 30, 150, 30);
		this.add(clientCheckbox);

		nameLabel = new JLabel();
		updateLabel();
		nameLabel.setBounds(30, 110, 300, 30);
		this.add(nameLabel);
		
		playerName = new JTextField(10);
		playerName.setBounds(30, 150, 300, 30);
		this.add(playerName);
		
		ok = new JButton("OK");
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
				if(isCheckingServer){
					ServerReversiFrame serverFrame = new ServerReversiFrame(owner, "reversi server", "", playerName.getText());
					serverFrame.setVisible(true);
					dispose();
				}else{
					ClientReversiFrame clientFrame = new ClientReversiFrame(owner, "reversi client", playerName.getText(), "");
					clientFrame.setVisible(true);
					dispose();
				}
				
			}
		});
		this.add(ok);

	}
	
	public void updateLabel(){
		if(isCheckingServer){
			nameLabel.setText("プレイヤー●の名前を入力してください");
		}else{
			nameLabel.setText("プレイヤー○の名前を入力してください");
		}
	}

}
