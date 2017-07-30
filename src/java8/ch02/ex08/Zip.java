package java8.ch02.ex08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Zip {
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Iterator<T> iterator = new Iterator<T>() {
			private Iterator<T> firstIterator = first.iterator();
			private Iterator<T> secondIterator = second.iterator();
			private boolean isFirst = true;

			public T next() {
				T result = isFirst ? firstIterator.next() : secondIterator.next();
				isFirst = !isFirst;
				return result;
			}

			public boolean hasNext() {
				return isFirst ? firstIterator.hasNext() : secondIterator.hasNext();
			}
		};
		
		Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
		return StreamSupport.stream(spliterator, false);
	}
	
	public static void main(String[] args) {
		List<String> first_words = Arrays.asList("aaa","bbb","ccc");
		List<String> second_words = Arrays.asList("111","222","333", "444", "555");
		Stream<String> first = first_words.stream();
		Stream<String> second = second_words.stream();
		zip(first, second).forEach(System.out::println);
	}

}
