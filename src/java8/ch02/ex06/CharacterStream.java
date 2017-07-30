package java8.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {
	public static Stream<Character> characterStream(String s) {
		return IntStream.rangeClosed(0, s.length() - 1).mapToObj((s::charAt));
	}
	
	public static void main(String[] args) {
		CharacterStream.characterStream("boat").forEach(System.out::println);
	}

}
