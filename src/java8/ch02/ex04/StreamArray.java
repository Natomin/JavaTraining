package java8.ch02.ex04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArray {
	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };
		Stream<int[]> stream = Stream.of(values);
		stream.forEach(System.out::println);
		//Stream<int[]>型になる。
		//Streamは参照型のオブジェクトを対象としているため、
		//プリミティブ型を使用する場合は専用のIntStreamなどを使用する必要がある。
		System.out.println("-------------");
		
		Stream<Integer> integerStream = Stream.of( 1, 4, 9, 16 );
		integerStream.forEach(System.out::println);
		System.out.println("-------------");
		
		IntStream intstream = Arrays.stream(new int[] {1, 4, 9, 16});
		intstream.forEach(System.out::println);
		System.out.println("-------------");
		

	}
	

}
