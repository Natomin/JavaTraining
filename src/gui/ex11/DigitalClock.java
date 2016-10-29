package gui.ex11;

//AWTのFrameを使用してデジタル時計を作成する
//paintメソッド内でGraphicsを使用して描画する。
import java.awt.*;

public class DigitalClock extends Frame {
	public DigitalClock() {
		super("DigitalClock");
		setSize(200, 100);
		addWindowListener(new MyWindowAdapter());
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawString("22:57",5,45);
	}
}
