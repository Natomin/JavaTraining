package gui.ex11.gui;

//AWTのFrameを使用してデジタル時計を作成する
//paintメソッド内でGraphicsを使用して描画する。
import java.awt.*;
import java.time.LocalTime;

public class DigitalClock extends Frame implements Observer{
	private String time = "00:00.00";
	public DigitalClock() {
		super("DigitalClock");
		setSize(220, 100);
		addWindowListener(new MyWindowAdapter());
		this.setVisible(true);

		Thread subTread = new Thread(new UpdateTimeRunnable(this));
		subTread.start();
	}
	
	public void setTime(String newTime){
		time = newTime;
	}

	public void paint(Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font);
		g.drawString(time, 10, 80);
	}

	@Override
	public void update() {
		LocalTime timeData = LocalTime.now();
		setTime(timeData.toString());
		repaint();
	}
	
}
