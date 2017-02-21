package jpl.ch14.ex02;

import org.junit.Test;

public class PrintServerTest {

	@Test
	public void test() {
		PrintServer server = new PrintServer();
		server.run();//Logで警告が出ることをを確認
	}

}
