package gui.ex24;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFrame;

public class DigitalClock extends JFrame {
	private String time = "00:00.00";
	private int fontSize = 50;
	private int fontStyle = Font.PLAIN;
	private String fontName = "serif";
	private Font font = new Font(fontName, fontStyle, fontSize);
	private Color textColor = Color.BLACK;
	private Color backGroundColor = Color.WHITE;
	private DigitalClock thisFrame = this;
	private GridBagLayout gblayout = new GridBagLayout();
	private String selectedFontSize = "50";
	private String selectedFont = "serif";
	private String selectedTextColor = "BLACK";
	private String selectedBackGroundColor = "WHITE";
	private Preferences prefs = Preferences.userNodeForPackage(getClass());
	private String stringFlameX = "10";
	private String stringFlameY = "10";
	private int flameX = 10;
	private int flameY = 10;

	public DigitalClock() {
		super("DigitalClock");

		// プリファレンスの読み込み
		selectedFont = prefs.get("Font", "serif");
		selectedFontSize = prefs.get("FontSize", "50");
		selectedTextColor = prefs.get("TextColor", "BLACK");
		selectedBackGroundColor = prefs.get("BackGroundColor", "WHITE");
		updateProperty(selectedFont, selectedFontSize, selectedTextColor, selectedBackGroundColor);
		flameX = prefs.getInt("stringFlameX", 10);
		flameY = prefs.getInt("stringFlameY", 10);

		// フレームの設定
		setSize(220, 100);
		setBackground(backGroundColor);
		setBounds(flameX, flameY, 220, 100);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// ×押された時の処理
				// プリファレンスの書き込み
				prefs.put("Font", selectedFont);
				prefs.put("FontSize", selectedFontSize);
				prefs.put("TextColor", selectedTextColor);
				prefs.put("BackGroundColor", selectedBackGroundColor);
				flameX = thisFrame.getX();
				flameY = thisFrame.getY();
				stringFlameX = String.valueOf(flameX);
				stringFlameY = String.valueOf(flameY);				
				prefs.put("stringFlameX", stringFlameX);
				prefs.put("stringFlameY", stringFlameY);
				try {
					prefs.flush();
				} catch (BackingStoreException e1) {
					e1.printStackTrace();
				}
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

		// プロパティにアクション（ダイアログ表示）を追加する
		property.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 表示するダイアログの設定
				Dialog propertyDialog = new Dialog(thisFrame, "プロパティ");
				GridBagLayout gblayout = new GridBagLayout();
				propertyDialog.setLayout(gblayout);// Layoutの追加
				propertyDialog.setSize(300, 200);
				propertyDialog.setResizable(false);
				propertyDialog.setVisible(true);
				propertyDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						// リソースの解放。×を押すとダイアログが閉じるように見える。
						propertyDialog.dispose();
					}
				});
				PropertyChoiceList choiceList = new PropertyChoiceList();
				// フォントラベルの追加
				Label fontLabel = new Label("フォント");
				GridBagConstraints flc = new GridBagConstraints();
				flc.anchor = GridBagConstraints.EAST;
				flc.gridx = 0;
				flc.gridy = 0;
				flc.gridwidth = 1;
				flc.gridheight = 1;
				gblayout.setConstraints(fontLabel, flc);
				propertyDialog.add(fontLabel);

				// フォント設定の追加
				Choice fontChoice = choiceList.getFontChoice();
				fontChoice.select(selectedFont);
				GridBagConstraints fcc = new GridBagConstraints();
				fcc.anchor = GridBagConstraints.WEST;
				fcc.gridx = 1;
				fcc.gridy = 0;
				fcc.gridwidth = 1;
				fcc.gridheight = 1;
				gblayout.setConstraints(fontChoice, fcc);
				propertyDialog.add(fontChoice);

				// フォントサイズラベルの追加
				Label fontSizeLabel = new Label("フォントサイズ");
				GridBagConstraints fsc = new GridBagConstraints();
				fsc.anchor = GridBagConstraints.EAST;
				fsc.gridx = 0;
				fsc.gridy = 1;
				fsc.gridwidth = 1;
				fsc.gridheight = 1;
				gblayout.setConstraints(fontSizeLabel, fsc);
				propertyDialog.add(fontSizeLabel);

				// フォントサイズ設定の追加
				Choice fontSizeChoice = choiceList.getFontSizeChoice();
				fontSizeChoice.select(selectedFontSize);
				GridBagConstraints fscc = new GridBagConstraints();
				fscc.anchor = GridBagConstraints.WEST;
				fscc.gridx = 1;
				fscc.gridy = 1;
				fscc.gridwidth = 2;
				fscc.gridheight = 1;
				gblayout.setConstraints(fontSizeChoice, fscc);
				propertyDialog.add(fontSizeChoice);

				// 文字色ラベルの追加
				Label textColorLabel = new Label("文字色");
				GridBagConstraints tclc = new GridBagConstraints();
				tclc.anchor = GridBagConstraints.EAST;
				tclc.gridx = 0;
				tclc.gridy = 2;
				tclc.gridwidth = 1;
				tclc.gridheight = 1;
				gblayout.setConstraints(textColorLabel, tclc);
				propertyDialog.add(textColorLabel);

				// 文字色設定の追加
				Choice textColorChoice = choiceList.getTextColorChoice();
				textColorChoice.select(selectedTextColor);
				GridBagConstraints tccc = new GridBagConstraints();
				tccc.anchor = GridBagConstraints.WEST;
				tccc.gridx = 1;
				tccc.gridy = 2;
				tccc.gridwidth = 4;
				tccc.gridheight = 1;
				gblayout.setConstraints(textColorChoice, tccc);
				propertyDialog.add(textColorChoice);

				// 背景色ラベルの追加
				Label backGroundColorLabel = new Label("背景色");
				GridBagConstraints bgclc = new GridBagConstraints();
				bgclc.anchor = GridBagConstraints.EAST;
				bgclc.gridx = 0;
				bgclc.gridy = 3;
				bgclc.gridwidth = 1;
				bgclc.gridheight = 1;
				gblayout.setConstraints(backGroundColorLabel, bgclc);
				propertyDialog.add(backGroundColorLabel);

				// 背景色設定の追加
				Choice backGroundColorChoice = choiceList.getbackGroundColorChoice();
				backGroundColorChoice.select(selectedBackGroundColor);
				GridBagConstraints bgccc = new GridBagConstraints();
				bgccc.anchor = GridBagConstraints.WEST;
				bgccc.gridx = 1;
				bgccc.gridy = 3;
				bgccc.gridwidth = 4;
				bgccc.gridheight = 1;
				gblayout.setConstraints(backGroundColorChoice, bgccc);
				propertyDialog.add(backGroundColorChoice);

				// OKボタンの追加
				Button ok = new Button("OK");
				ok.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						updateProperty(fontSizeChoice, fontChoice, textColorChoice, backGroundColorChoice);
					}
				});
				GridBagConstraints okc = new GridBagConstraints();
				okc.anchor = GridBagConstraints.SOUTHEAST;
				okc.gridx = 2;
				okc.gridy = 5;
				okc.gridwidth = 2;
				okc.gridheight = 1;
				gblayout.setConstraints(ok, okc);
				propertyDialog.add(ok);

				// キャンセルボタンの追加
				Button cancel = new Button("cancel");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						propertyDialog.dispose();
					}
				});
				GridBagConstraints cancelc = new GridBagConstraints();
				cancelc.anchor = GridBagConstraints.SOUTHEAST;
				cancelc.gridx = 0;
				cancelc.gridy = 5;
				cancelc.gridwidth = 3;
				cancelc.gridheight = 1;
				gblayout.setConstraints(cancel, cancelc);
				propertyDialog.add(cancel);

			}
		});
		this.setMenuBar(menuBar);
		// サブスレッドにフレームを渡す
		Thread subTread = new Thread(new UpdateTimeRunnable(this));
		subTread.start();
	}

	// 渡された現在時刻の値をセットする
	public void setTime(String hour, String minute, String seconds) {
		time = hour + ":" + minute + "." + seconds;
	}

	// 描画処理
	public void paint(Graphics g) {
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		Dimension newSize = new Dimension(fm.stringWidth(time) + 20,
				fm.getAscent() + fm.getDescent() + fm.getLeading() + 20);
		thisFrame.setSize(newSize);

		Dimension d = getSize();
		Image back = createImage(d.width, d.height);
		Graphics buffer = back.getGraphics();
		buffer.setFont(font);
		buffer.setColor(textColor);

		int x = d.width / 2 - fm.stringWidth(time) / 2;
		int y = d.height / 2 + fm.getDescent() + 20;
		buffer.drawString(time, x, y);
		g.drawImage(back, 0, 0, this);
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
		selectedFontSize = fSizeChoice.getSelectedItem();
		setFontSize(Integer.parseInt(selectedFontSize));

		selectedFont = fChoice.getSelectedItem();
		setFontStyle(Font.decode(selectedFont));

		selectedTextColor = tColorChoice.getSelectedItem();
		settextColor(selectedTextColor);

		selectedBackGroundColor = bgColorChoice.getSelectedItem();
		setBackGroundColor(selectedBackGroundColor);
	}

	public void updateProperty(String font, String fontSize, String textColor, String backGroundColor) {
		selectedFont = font;
		setFontStyle(Font.decode(selectedFont));

		selectedFontSize = fontSize;
		setFontSize(Integer.parseInt(selectedFontSize));

		selectedTextColor = textColor;
		settextColor(selectedTextColor);

		selectedBackGroundColor = backGroundColor;
		setBackGroundColor(selectedBackGroundColor);

	}

}

