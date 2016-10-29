package gui.ex11;

public class UpdateTimeRunnable implements Runnable {
	private DigitalClock clockFlame;
	private int hour = 0;
	private int minute = 0;
	private int second = 0;

	public UpdateTimeRunnable(DigitalClock clockFlame, int hour, int minute, int second) {
		this.clockFlame = clockFlame;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public void run() {
		updateTime();
		while (true) {
			while (hour < 24) {
				while (minute < 60) {
					while (second < 60) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						second++;
						updateTime();
					}
					minute++;
					second = 0;
					updateTime();
				}
				hour++;
				minute = 0;
				second = 0;
				updateTime();
			}
			hour = 0;
			minute = 0;
			second = 0;
			updateTime();
		}
	}

	private void updateTime() {
		String newTime = toString(hour) + ":" + toString(minute) + "." + toString(second);
		clockFlame.setTime(newTime);
		clockFlame.repaint();
	}
	
	private String toString(int time){
		if(time < 10){
			return "0" + time;
		}else{
			return String.valueOf(time);
		}
	}

}
