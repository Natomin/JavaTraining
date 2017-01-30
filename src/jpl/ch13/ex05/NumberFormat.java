package jpl.ch13.ex05;

public class NumberFormat {
	
	public String numberFormatter(String numberData){
		StringBuilder builder = new StringBuilder(numberData);
		builder.reverse();
		for(int i = 0; i < builder.length(); i++){
			if(i % 4 == 3){
				builder.insert(i, ',');				
			}
		}
		builder.reverse();
		return builder.toString();
	}

}
