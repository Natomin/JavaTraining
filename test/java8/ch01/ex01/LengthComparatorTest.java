package java8.ch01.ex01;


import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class LengthComparatorTest {

	@Test
	public void test() {
		String[] strings = {"11111", "22", "333333", "4444", "55555555"};
		String[] expected = {"22", "4444", "11111",  "333333", "55555555"};
		
		Arrays.sort(strings, new LengthComparator());
		for(int i = 0; i < strings.length; i++){
			assertTrue(expected[i].equals(strings[i]));
		}
	}

}
