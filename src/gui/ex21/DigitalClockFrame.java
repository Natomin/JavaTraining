package gui.ex21;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.ex21.Subject.Observer;

public class DigitalClockFrame extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private GraphicComponrnts graphic = new GraphicComponrnts();

	public DigitalClockFrame() {
		setSize(470, 150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Components追加
		getContentPane().add(graphic);
		setVisible(true);
	}

	@Override
	public void update(String time) {
		graphic.setTime(time);
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
