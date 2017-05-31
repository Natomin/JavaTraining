package gui.ex22;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class UpdateTimeRunnable implements Runnable{

	private DigitalClockFrame clockFlame;

	public UpdateTimeRunnable(DigitalClockFrame clockFlame) {
		this.clockFlame = clockFlame;
	}

	@Override
	public void run() {
		while (true) {
			//時間の取得と描画処理
			String hour = new DecimalFormat("00").format(LocalTime.now().getHour());
			String minute = new DecimalFormat("00").format(LocalTime.now().getMinute());
			String seconds = new DecimalFormat("00").format(LocalTime.now().getSecond());//一桁の場合は0で埋めて二桁にする処理
			clockFlame.setTime(hour, minute, seconds);
			clockFlame.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
