package java8.ch02.ex05;

import java.util.stream.LongStream;

public class RandomStream {
	public static LongStream random(long seed) {
	    final long a = 25214903917L;
	    final long c = 11;
	    final long m = (long) Math.pow(2, 48);
	    return LongStream.iterate(seed, x -> (a*x + c) % m);
	}
	
	public static void main(String[] args) {
		RandomStream.random(1).forEach(System.out::println);
	}

}
