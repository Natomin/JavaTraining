package jpl.ch14.ex10;

import java.util.ArrayList;

public class Queue {
	private int queueSize;
	private ArrayList<Runnable> queue;

	public Queue(int queueSize) {
		this.queueSize = queueSize;
		queue = new ArrayList<Runnable>(queueSize);
	}

	public synchronized void push(Runnable runnable) {
		while (queueSize <= queue.size()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// queueにtaskが入りきらないので待つ
		}
		queue.add(runnable);
	}

	public synchronized Runnable pop() {
		if (queue.size() < 1) {
			return null;
		}
		return queue.remove(0);
	}

	public int getQueueSize() {
		return queue.size();
	}

}
