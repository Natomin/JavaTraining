package jpl.ch24.ex01;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;

public class GlobalRes_fr extends ResourceBundle{

	@Override
	protected Object handleGetObject(String key) {
		if(key.equals("hello")){
			return "Bonjour";
		}else if (key.equals("goodbye")){
			return "Au Revoir";
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		Vector<String> vec = new Vector<>();
		vec.add("hello");
		vec.add("goodbye");
		java.util.Enumeration<String> enu = vec.elements();
		return enu;
	}

}
