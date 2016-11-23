package gui.ex11.gui;

public abstract class Subject {
	public void setCurrentTime(Observer clockFlame){
		clockFlame.update();
	}
}
