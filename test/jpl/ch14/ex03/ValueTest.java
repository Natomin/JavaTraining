package jpl.ch14.ex03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ValueTest {
	private Value value = new Value(); 
	
	private class TestThread extends Thread{
		public void run(){
			try{
				for(int i = 0; i < 100; i++){
					value.add();
					Thread.sleep(1);
				}
			}catch (Exception e) {
			}
		}
	}

	@Test
	public void test() {
		for(int i = 0; i < 100; i++){
			new TestThread().start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		assertEquals(10000, value.getValue());
		
		
		
	}

}
