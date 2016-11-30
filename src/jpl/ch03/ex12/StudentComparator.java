package jpl.ch03.ex12;

import java.util.Comparator;

public class StudentComparator implements Comparator<Object>{

	@Override//ageを比較する
	public int compare(Object o1, Object o2) {
		if((o1 instanceof Student)&&(o2 instanceof Student)){
			return ((Student)o1).getAge() - ((Student)o2).getAge();
		}else{
			return 0;
		}
	}
	
}
