package java8.ch03.ex07;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Test;


public class ComparatorGeneratorTest {

	@Test
	public void test1() {
		ComparatorGenerator generator = new ComparatorGenerator();
		Comparator<String> comparator = generator.generateComparator();
		assertTrue(comparator.compare("a", "b") < 0);
		assertTrue(comparator.compare("a", "a") == 0);
		assertTrue(comparator.compare("a", "A") > 0);
		assertTrue(comparator.compare("b", "a") > 0);
	}
	@Test
	public void test2() {
		ComparatorGenerator generator = new ComparatorGenerator();
		Comparator<String> comparator = generator.generateComparator(Condition.NO_DISTINCTION_CASE);
		assertTrue(comparator.compare("a", "b") < 0);
		assertTrue(comparator.compare("a", "a") == 0);
		assertTrue(comparator.compare("a", "A") == 0);
		assertTrue(comparator.compare("b", "a") > 0);
	}
	
	@Test
	public void test3() {
		ComparatorGenerator generator = new ComparatorGenerator();
		Comparator<String> comparator = generator.generateComparator(Condition.DESCENDING_ORDER);
		assertTrue(comparator.compare("a", "b") > 0);
		assertTrue(comparator.compare("a", "a") == 0);
		assertTrue(comparator.compare("a", "A") < 0);
		assertTrue(comparator.compare("b", "a") < 0);
	}
	
	@Test
	public void test4() {
		ComparatorGenerator generator = new ComparatorGenerator();
		Comparator<String> comparator = generator.generateComparator(Condition.DESCENDING_ORDER, Condition.NO_DISTINCTION_CASE);
		assertTrue(comparator.compare("a", "b") > 0);
		assertTrue(comparator.compare("a", "a") == 0);
		assertTrue(comparator.compare("a", "A") == 0);
		assertTrue(comparator.compare("b", "a") < 0);
	}
	
	@Test
	public void test5() {
		ComparatorGenerator generator = new ComparatorGenerator();
		Comparator<String> comparator = generator.generateComparator(Condition.NO_DISTINCTION_SPACE);
		assertTrue(comparator.compare("a", "a ") == 0);
		assertTrue(comparator.compare("a ", "a") == 0);
	}
	

}
