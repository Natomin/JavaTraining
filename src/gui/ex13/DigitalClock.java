package gui.ex13;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.PopupMenu;

public class DigitalClock extends Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time = "00:00.00";
	private int fontSize = 50;
	private int fontStyle = Font.PLAIN;
	private String fontName = "serif";
	private Font font = new Font(fontName, fontStyle, fontSize);
	private Color textColor = Color.BLACK;
	private Color backGroundColor = Color.WHITE;
	private DigitalClock thisFrame = this;
	PopupMenu pop;
	private int clickedPointX = 0;
	private int clickedPointY = 0;
	private Point clickedLocation;

	public void setClickedPointX(int clickedPointX) {
		this.clickedPointX = clickedPointX;
	}

	public void setClickedPointY(int clickedPointY) {
		this.clickedPointY = clickedPointY;
	}


	public DigitalClock() {
		super(null);
		// フレームの設定
		setSize(220, 100);
		setBackground(backGroundColor);
		this.setVisible(true);

		//ポップアップメニューの設定
		ClockMenu menu = new ClockMenu(this);
		pop = menu.getPopupMenu();
		//右クリックされたらpopをshowする
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				if(e.getButton() == MouseEvent.BUTTON3){
					pop.show(DigitalClock.this, e.getX(), e.getY());
				}else if(e.getButton() == MouseEvent.BUTTON1){
					setClickedPointX(e.getXOnScreen());
					setClickedPointY(e.getYOnScreen());
					clickedLocation = getLocation();
				}
			}
			
		});
		thisFrame.add(pop);
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int newX  = e.getXOnScreen();
				int newY = e.getYOnScreen();
				setLocation(clickedLocation.x + newX - clickedPointX, clickedLocation.y + newY - clickedPointY);
				
			}
		});

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
				fm.getAscent() + fm.getDescent() + fm.getLeading());
		thisFrame.setSize(newSize);
		
		Dimension d = getSize();
		Image back = createImage(d.width, d.height);
		Graphics buffer = back.getGraphics();
		buffer.setFont(font);
		buffer.setColor(textColor);

		int flameX = d.width / 2 - fm.stringWidth(time) / 2;
		int flameY = d.height / 2 + fm.getDescent() + 5;
		buffer.drawString(time, flameX, flameY);
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
