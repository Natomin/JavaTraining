package jpl.ch14.ex10;

import java.util.ArrayList;

public class Queue {
	private int queueSize;
	private ArrayList<Runnable> queue;
	//protected static final Object pushLock = new Object();
	//protected static final Object popLock = new Object();
	protected static final Object lock = new Object();

	public Queue(int queueSize) {
		this.queueSize = queueSize;
		queue = new ArrayList<Runnable>(queueSize);
	}

	public void push(Runnable runnable) {
		synchronized(lock){
			while (queueSize <= queue.size()) {
				try {
					wait();
					//Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				// queueにtaskが入りきらないので待つ
			}
			queue.add(runnable);
		}
		
	}

	public Runnable pop() {
		synchronized(lock){
			if (queue.size() < 1) {
				return null;
			}
			return queue.remove(0);
		}
		
	}

	public int getQueueSize() {
		return queue.size();
	}

}
