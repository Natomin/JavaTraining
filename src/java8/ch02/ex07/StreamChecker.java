package java8.ch02.ex07;

import java.util.Spliterator;
import java.util.stream.Stream;

//終端処理（spliterator）をしてしまっているので、使い時はよくわからない
public class StreamChecker {
	public static <T> boolean isFinite(Stream<T> stream){
		return stream.spliterator().hasCharacteristics(Spliterator.SIZED);
		//sizeが有限な場合はtrue
	}

}
