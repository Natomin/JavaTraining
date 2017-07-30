package java8.ch02.ex10;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class AverageTest {

	@Test
	public void test() {
		Double[] data = { 1.0, 2.0, 3.0, 4.0 };
		Stream<Double> stream = Stream.of(data);
		assertEquals(Average.ave(stream), 2.5, 0.1);
	}

}
