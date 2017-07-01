package gui.ex21;

import java.util.ArrayList;
import java.util.List;



public abstract class Subject {
	private List<Observer> observerList = new ArrayList<Subject.Observer>();
	
	public interface Observer{
		public void update();
	}
	
	public void addObserver(Observer observer){
		observerList.add(observer);
	}
	
	public void notifyObserver(){
		for(Observer o : observerList){
			o.update();
		}
	}
	
	abstract public void done();

}
