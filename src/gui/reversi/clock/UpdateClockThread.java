package gui.reversi.clock;

import java.text.DecimalFormat;
import java.time.LocalTime;

import gui.reversi.frame.IReversiFrame;

public class UpdateClockThread extends Thread{
	IReversiFrame reversiFrame;
	public UpdateClockThread(IReversiFrame reversiFrame) {
		this.reversiFrame = reversiFrame;
	}
	
	@Override
	public void run() {
		while (true) {
			String hour = new DecimalFormat("00").format(LocalTime.now().getHour());
			String minute = new DecimalFormat("00").format(LocalTime.now().getMinute());
			String seconds = new DecimalFormat("00").format(LocalTime.now().getSecond());//一桁の場合は0で埋めて二桁にする処理
			reversiFrame.updateTime(hour + ":" + minute + "." + seconds);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
