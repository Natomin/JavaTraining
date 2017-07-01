package gui.ex21;

import java.time.LocalTime;



public class TimeKeeper extends Subject implements Runnable {
	private LocalTime time;

	public LocalTime getTime() {
		return time;
	}


	public TimeKeeper(Observer clockFlame) {
		addObserver(clockFlame);
	}

	@Override
	public void done() {
		// 時間の取得
		time = LocalTime.now();
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

