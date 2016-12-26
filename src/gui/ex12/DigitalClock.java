package gui.ex12;
//AWTのFrameを使用してデジタル時計を作成する

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.plaf.FontUIResource;

public class DigitalClock extends Frame {
	private String time = "00:00.00";
	private int fontSize = 50;
	private int fontStyle = Font.PLAIN;
	private String fontName = "serif";
	private Font font = new Font(fontName, fontStyle, fontSize);
	private Color textColor = Color.BLACK;
	private Color backGroundColor = Color.WHITE;
	private DigitalClock thisFrame = this;

	public DigitalClock() {
		// フレームの設定
		super("DigitalClock");
		setSize(220, 100);
		setBackground(backGroundColor);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// ×で閉じる処理
				System.exit(0);
			}
		});
		this.setVisible(true);
		// メニューバーに"プロパティ"を追加する
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("メニュー");
		menuBar.add(menu);
		// "メニュー"に"プロパティ"を追加する
		MenuItem property = menu.add(new MenuItem("プロパティ"));

//		DigitalClock thisFrame = this;
		// プロパティにアクション（ダイアログ表示）を追加する
		property.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 表示するダイアログの設定
				Dialog propertyDialog = new Dialog(thisFrame, "プロパティ");
				propertyDialog.setLayout(null);
				propertyDialog.setSize(400, 300);
				propertyDialog.setVisible(true);
				propertyDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						// リソースの解放。×を押すとダイアログが閉じるように見える。
						dispose();// 呼び出し元のフレームも消えちゃう
					}
				});
				PropertyChoiceList choiceList = new PropertyChoiceList();
				// フォントサイズ設定の追加
				Choice fontSizeChoice = choiceList.getFontSizeChoice();
				fontSizeChoice.setBounds(120, 50, 250, 30);
				propertyDialog.add(fontSizeChoice);
				// フォントサイズラベルの追加
				Label fontSizeLabel = new Label("フォントサイズ");
				fontSizeLabel.setBounds(15, 50, 100, 30);
				propertyDialog.add(fontSizeLabel);
				// フォント設定の追加
				Choice fontChoice = choiceList.getFontChoice();
				fontChoice.setBounds(120, 100, 250, 30);
				propertyDialog.add(fontChoice);
				// フォントラベルの追加
				Label fontLabel = new Label("フォント");
				fontLabel.setBounds(15, 100, 100, 30);
				propertyDialog.add(fontLabel);
				// 文字色設定の追加
				Choice textColorChoice = choiceList.getTextColorChoice();
				textColorChoice.setBounds(120, 150, 250, 30);
				propertyDialog.add(textColorChoice);
				// 文字色ラベルの追加
				Label textColorLabel = new Label("文字色");
				textColorLabel.setBounds(15, 150, 100, 30);
				propertyDialog.add(textColorLabel);
				// 背景色設定の追加
				Choice backGroundColorChoice = choiceList.getbackGroundColorChoice();
				backGroundColorChoice.setBounds(120, 200, 250, 30);
				propertyDialog.add(backGroundColorChoice);

				// 背景色ラベルの追加
				Label backGroundColorLabel = new Label("背景色");
				backGroundColorLabel.setBounds(15, 200, 100, 30);
				propertyDialog.add(backGroundColorLabel);
				// OKボタンの追加
				Button ok = new Button("OK");
				ok.setBounds(300, 250, 80, 30);
				ok.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						updateProperty(fontSizeChoice, fontChoice, textColorChoice, backGroundColorChoice);
					}
				});
				propertyDialog.add(ok);

			}
		});
		this.setMenuBar(menuBar);
		// サブスレッドにフレームを渡す
		Thread subTread = new Thread(new UpdateTimeRunnable(this));
		subTread.start();
	}

	// 渡された現在時刻の値をセットする
	public void setTime(String newTime) {
		time = newTime;
	}

	// 描画処理
	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(textColor);
		FontMetrics fm = g.getFontMetrics();
		Dimension newSize = new Dimension(fm.stringWidth(time), fm.getAscent() + fm.getDescent() + fm.getLeading() + 20);
		thisFrame.setSize(newSize);
		Dimension d = getSize();
		int x = d.width / 2 - fm.stringWidth(time) / 2;
		int y = d.height / 2 + fm.getDescent() + 20;
		g.drawString(time, x, y);
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
		font = font.deriveFont((float) fontSize);
	}

	public void setFontStyle(Font f) {
		font = f;
		font = font.deriveFont((float) fontSize);
	}

	public void settextColor(String color) {
		switch (color) {
		case "black":
			textColor = Color.black;
			break;
		case "cyan":
			textColor = Color.cyan;
			break;
		case "magenta":
			textColor = Color.magenta;
			break;
		case "yellow":
			textColor = Color.yellow;
			break;
		default:
			break;
		}
	}

	public void setBackGroundColor(String color) {
		switch (color) {
		case "white":
			backGroundColor = Color.white;
			break;
		case "cyan":
			backGroundColor = Color.cyan;
			break;
		case "magenta":
			backGroundColor = Color.magenta;
			break;
		case "yellow":
			backGroundColor = Color.yellow;
			break;
		case "pink":
			backGroundColor = Color.pink;
			break;
		case "green":
			backGroundColor = Color.green;
			break;
		default:
			break;
		}
		this.setBackground(backGroundColor);
	}

	public void updateProperty(Choice fSizeChoice, Choice fChoice, Choice tColorChoice, Choice bgColorChoice) {
		String selectedFontSize = fSizeChoice.getSelectedItem();
		setFontSize(Integer.parseInt(selectedFontSize));

		String selectedFont = fChoice.getSelectedItem();
		setFontStyle(Font.decode(selectedFont));

		String selectedTextColor = tColorChoice.getSelectedItem();
		settextColor(selectedTextColor);

		String selectedBackGroundColor = bgColorChoice.getSelectedItem();
		setBackGroundColor(selectedBackGroundColor);
	}

}
