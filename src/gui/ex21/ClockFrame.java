package gui.ex21;

import gui.ex21.Subject.Observer;

public interface ClockFrame extends Observer {
	public void setTime(String nowTime);

}
