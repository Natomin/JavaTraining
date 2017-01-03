package jpl.ch10.ex05;
//目視テスト
import org.junit.Test;
public class CharDataTest {
	@Test
	public void test() {
		CharData charaData = new CharData();
		charaData.printCharLine('b', 'k');
	}
	@Test
	public void test2() {
		CharData charaData = new CharData();
		charaData.printCharLine('ぱ', 'ぺ');
	}

}
