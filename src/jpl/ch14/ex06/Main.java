package jpl.ch14.ex06;

public class Main {

	public static void main(String[] args) {
		SyncObject syncObj = new SyncObject();
		TimeDisplay time = new TimeDisplay(syncObj, new MassageDisplay(syncObj, 15, "15秒たったよ"));
		new Thread(time).start();
		time.startMessageThread(new MassageDisplay(syncObj, 7, "7秒たったよ"));
	}

}
