package jpl.ch14.ex04;


import org.junit.Test;


public class ValueStaticTest {	
	private class TestThread extends Thread{
		public void run(){
			try{
				while(true){
					ValueStatic.add();
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
	}

}
