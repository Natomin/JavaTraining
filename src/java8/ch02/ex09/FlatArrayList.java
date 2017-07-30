package java8.ch02.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatArrayList {

	public static <T> ArrayList<T> combineList1(Stream<ArrayList<T>> values) {
		return values.reduce(new ArrayList<T>(), (l, w) -> {
			l.addAll(w);
			return l;
		});
	}
	
	public static <T> ArrayList<T> combineList2(Stream<ArrayList<T>> values) {
		return values.reduce((l, w) -> {
			l.addAll(w);
			return l;
		}).orElse(new ArrayList<T>());
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		Stream<String> streamList = list.stream();
		//Stream<ArrayList<T>>の作り方がわからない・・・
	}
}
