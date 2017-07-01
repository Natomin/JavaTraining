package jpl.ch22.ex14;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SplitString {
	
	private List<String> splitString(String data){
		List<String> splitData = new ArrayList<>();
		StringTokenizer tokens = new StringTokenizer(data, " ");
		while(tokens.hasMoreTokens()){
			splitData.add(tokens.nextToken());
		}
		return splitData;
	}
	
	public double sum(String data){
		List<String> splitData = splitString(data);
		double sum = 0;
		for(String s : splitData){
			sum = sum + Double.valueOf(s);
		}
		return sum;
	}


}
