package gui.ex21;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class TimeKeeper extends Subject implements Runnable {
	private ClockFrame clockFrame;

	public TimeKeeper(ClockFrame clockFlame) {
		this.clockFrame = clockFlame;
		addObserver(clockFlame);
	}

	@Override
	public void done() {
		// 時間の取得
		String hour = new DecimalFormat("00").format(LocalTime.now().getHour());
		String minute = new DecimalFormat("00").format(LocalTime.now().getMinute());
		String seconds = new DecimalFormat("00").format(LocalTime.now().getSecond());// 一桁の場合は0で埋めて二桁にする処理
		String time = hour + ":" + minute + "." + seconds;
		clockFrame.setTime(time);
		// 時間の変更をFrameに知らせる
		notifyObserver();
	}

	@Override
	public void run() {
		while (true) {
			done();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
