package java8.ch03.ex20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MapperTest {

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("aaaa");
		list.add("aaa");
		list.add("aa");
		list.add("aaaaa");
		list.add("aaaaaaaa");
		List<Integer> result = Mapper.map(list, (s) -> s.length());
		
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(result.get(i));
			assertEquals((int)list.get(i).length(), (int)result.get(i));
		}
		
	}

}
