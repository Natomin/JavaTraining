package java8.ch02.ex13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelCounter {

	public static Map<Object, List<String>> parallelCount(Stream<String> words, int wordLength){
		Map<Object, List<String>> map = words.filter(w -> w.length() < wordLength).collect(Collectors.groupingBy(s -> s.length()));
		return map;
	}
	
}
