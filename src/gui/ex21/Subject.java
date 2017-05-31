package gui.ex21;

import java.util.ArrayList;
import java.util.List;


public abstract class Subject {
	private List<Observer> observerList = new ArrayList<Subject.Observer>();
	
	public interface Observer{
		public void update(String time);
	}
	
	public void addObserver(Observer observer){
		observerList.add(observer);
	}
	
	public void notifyObserver(String time){
		for(Observer o : observerList){
			o.update(time);
		}
	}
	
	abstract public void done();

}
