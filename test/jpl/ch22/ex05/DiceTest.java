package jpl.ch22.ex05;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DiceTest {
	private Map<Integer, Integer> distribution = new HashMap<>();
	private Map<Integer, Double> theoreticalP = new HashMap<>();
	
	{
		theoreticalP.put(2, 1/36.0);
		theoreticalP.put(3, 2/36.0);
		theoreticalP.put(4, 3/36.0);
		theoreticalP.put(5, 4/36.0);
		theoreticalP.put(6, 5/36.0);
		theoreticalP.put(7, 6/36.0);
		theoreticalP.put(8, 5/36.0);
		theoreticalP.put(9, 4/36.0);
		theoreticalP.put(10, 3/36.0);
		theoreticalP.put(11, 2/36.0);
		theoreticalP.put(12, 1/36.0);
	}
	
	public void add(int sum){
		if(distribution.containsKey(sum)){
			int num = distribution.get(sum);
			distribution.put(sum, num + 1);
		}else{
			distribution.put(sum, 1);
		}
	}
	
	@Test
	public void test() {
		double count = 10000000.0;
		for (int i = 0; i < count; i++) {
			int sum = Dice.roll() + Dice.roll();
			add(sum);
		}

		for(int key = 2; key <= 12; key++){
			System.out.println("sum : " + key);
			System.out.println("expecteds : " + theoreticalP.get(key));
			System.out.println("actuals : " + distribution.get(key)/count);
			assertEquals(theoreticalP.get(key).doubleValue(), distribution.get(key)/count, 0.001);
		}

		
	}

}
