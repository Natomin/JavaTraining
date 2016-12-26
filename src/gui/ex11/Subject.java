package gui.ex11;

public abstract class Subject {
	public void setCurrentTime(Observer clockFlame){
		clockFlame.update();
	}
}
