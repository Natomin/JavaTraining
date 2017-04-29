package gui.ex21;

public class Main {

	public static void main(String[] args) {
		DigitalClockFrame clockFrame = new DigitalClockFrame();
		new Thread(new TimeKeeper(clockFrame)).start();
		;
	}

}
