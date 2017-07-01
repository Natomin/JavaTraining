package jpl.ch22.ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AttrObserver implements java.util.Observer{

		private Map<String, Attr> attrMap = new HashMap<>();
		ObservedAttributed attributed;
		public AttrObserver(ObservedAttributed attributed){
			this.attributed = attributed;
			attributed.addObserver(this);
		}
		
		@Override
		public void update(Observable o, Object arg) {
			attrMap = (Map<String, Attr>) arg;
			printAll();
		}
		
		public void printAll(){
			for(String s : attrMap.keySet()){
				Attr attr = attrMap.get(s);
				System.out.println(attr);
			}
		}
}
