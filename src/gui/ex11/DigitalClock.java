package gui.ex11;

//AWTのFrameを使用してデジタル時計を作成する
//paintメソッド内でGraphicsを使用して描画する。
import java.awt.*;

public class DigitalClock extends Frame {
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
	
}
