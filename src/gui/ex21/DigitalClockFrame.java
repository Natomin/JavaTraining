package gui.ex21;

import java.awt.Graphics;
import java.text.DecimalFormat;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.ex21.Subject.Observer;

public class DigitalClockFrame extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private TimeKeeper timeKeeper = new TimeKeeper(this);
	private GraphicComponrnts graphic = new GraphicComponrnts();

	public DigitalClockFrame() {
		setSize(470, 150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Components追加
		getContentPane().add(graphic);
		setVisible(true);
		timeKeeper.run();
	}

	@Override
	public void update() {
		LocalTime time = timeKeeper.getTime();
		String hour = new DecimalFormat("00").format(time.getHour());
		String minute = new DecimalFormat("00").format(time.getMinute());
		String seconds = new DecimalFormat("00").format(time.getSecond());// 一桁の場合は0で埋めて二桁にする処理
		graphic.setTime(hour + ":" + minute + "." + seconds);
		graphic.repaint();
	}

	public class GraphicComponrnts extends JPanel {
		private String time = "00:00,00";
		private Propaty propaty = new Propaty();
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(propaty.getFont());
			g.drawString(time, 10, 100);
		}

		public void setTime(String time) {
			this.time = time;
		}
	}
}

