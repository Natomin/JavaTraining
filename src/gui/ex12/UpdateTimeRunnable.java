package gui.ex12;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class UpdateTimeRunnable implements Runnable{

	private DigitalClock clockFlame;

	public UpdateTimeRunnable(DigitalClock clockFlame) {
		this.clockFlame = clockFlame;
	}

	@Override
	public void run() {
		while (true) {
			//時間の取得と描画処理
			LocalTime timeData = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
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
