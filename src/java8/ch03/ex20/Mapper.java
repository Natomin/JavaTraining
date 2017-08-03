package java8.ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Mapper {
	public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
		List<U> result = new ArrayList<U>();
		for (T t : list) {
			result.add(mapper.apply(t));
		}
		return result;

	}

}
