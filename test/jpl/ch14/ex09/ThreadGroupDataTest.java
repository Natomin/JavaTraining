package jpl.ch14.ex09;


import org.junit.Test;

public class ThreadGroupDataTest {
	ThreadGroup groupA = new ThreadGroup("GroupA");
	ThreadGroup groupAA = new ThreadGroup(groupA, "GroupAA");
	ThreadGroupData groupData = new ThreadGroupData();
	

	@Test
	public void test() {
		new Thread(groupA, new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i < 10000){
					try {
						Thread.sleep(500);
						System.out.println("Thread1");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
				
			}
		}, "Thread1").start();
		
		new Thread(groupA, new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i < 4000){
					try {
						Thread.sleep(500);
						System.out.println("Thread2");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
				
			}
		}, "Thread2").start();
		
		new Thread(groupAA, new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i < 3000){
					try {
						Thread.sleep(3000);
						System.out.println("Thread3");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
				
			}
		}, "Thread3").start();
		
		groupData.startThread(groupAA);
	}
	
	
}
