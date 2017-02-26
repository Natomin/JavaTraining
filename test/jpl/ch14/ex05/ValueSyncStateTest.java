package jpl.ch14.ex05;


import org.junit.Test;

public class ValueSyncStateTest {
	private class TestAddThread extends Thread{
		public void run(){
			try{
				while(true){
					ValueSyncState.add();
					Thread.sleep(1);
				}
			}catch (Exception e) {
			}
		}
	}
	
	private class TestSubThread extends Thread{
		public void run(){
			try{
				while(true){
					ValueSyncState.sub();
					Thread.sleep(5);
				}
			}catch (Exception e) {
			}
		}
	}

	@Test
	public void test() {
		for(int i = 0; i < 100; i++){
			new TestAddThread().start();
			new TestSubThread().start();
		}

		
	}

}
