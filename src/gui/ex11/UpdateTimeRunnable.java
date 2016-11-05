package gui.ex11;

import java.time.LocalTime;

public class UpdateTimeRunnable implements Runnable {
	private DigitalClock clockFlame;

	public UpdateTimeRunnable(DigitalClock clockFlame) {
		this.clockFlame = clockFlame;
	}

	@Override
	public void run() {
		while (true) {
			LocalTime timeData = LocalTime.now();
			clockFlame.setTime(timeData.toString());
			clockFlame.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
