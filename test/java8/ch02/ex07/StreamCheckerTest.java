package java8.ch02.ex07;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class StreamCheckerTest {

	@Test
	public void finiteTest() {
		Stream<Integer> integerStream = Stream.of( 1, 4, 9, 16 );
		assertTrue(StreamChecker.isFinite(integerStream));
	}
	
	@Test
	public void infiniteTest() {
		Stream<Double> stream = Stream.generate(() -> Math.random());
		assertFalse(StreamChecker.isFinite(stream));
	}

}
