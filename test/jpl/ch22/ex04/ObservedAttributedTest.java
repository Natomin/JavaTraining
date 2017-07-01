package jpl.ch22.ex04;

import org.junit.Test;

public class ObservedAttributedTest {

	@Test
	public void test() {
		ObservedAttributed attributed = new ObservedAttributed();
		new AttrObserver(attributed);
		System.out.println("add test 'aaaa'");
		attributed.add(new Attr("aaaa", 100));
		System.out.println();
		
		System.out.println("add test 'bbbb'");
		attributed.add(new Attr("bbbb", 200));
		System.out.println();
		
		System.out.println("add test 'cccc'");
		attributed.add(new Attr("cccc", 500));
		System.out.println();
		
		System.out.println("remove test 'bbbb'");
		attributed.remove("bbbb");
		System.out.println();
		
		System.out.println("remove test 'aaaa'");
		attributed.remove("aaaa");
		System.out.println();
		
	}
	

}
