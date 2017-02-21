package jpl.ch14.ex03;


import org.junit.Test;

public class ValueTest {
	private Value value = new Value(); 
	
	private class TestThread extends Thread{
		public void run(){
			try{
				while(true){
					value.add();
					Thread.sleep(1);
				}
			}catch (Exception e) {
			}
		}
	}

	@Test
	public void test() {
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();
		
	}

}
