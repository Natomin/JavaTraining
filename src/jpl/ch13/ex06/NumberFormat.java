package jpl.ch13.ex06;

public class NumberFormat {
	public String numberFormatter(String numberData, int num, String delimiter){
	StringBuilder builder = new StringBuilder(numberData);
	
	builder.reverse();
	for(int i = 0; i < builder.length(); i++){
		if(i % (num + 1) == num){
			builder.insert(i, delimiter);				
		}
	}
	builder.reverse();
	return builder.toString();
}

}
