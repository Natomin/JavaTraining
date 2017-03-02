package jpl.ch14.ex10;

public class ThreadPool {
	private boolean isStart;
	private Queue queue;
	private LoopThread[] thread;

	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		queue = new Queue(queueSize);
		thread = new LoopThread[numberOfThreads];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new LoopThread();
		}
		// throw new AssertionError("Not Implemented Yet");
	}

	public void start() {
		if (isStart) {
			throw new IllegalStateException();
		}
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
		isStart = true;
		// throw new AssertionError("Not Implemented Yet");
	}

	public void stop() {
		if (!isStart) {
			throw new IllegalStateException();
		}

		for (int i = 0; i < thread.length; i++) {
			thread[i].finnish();
		}
		// while(Thread.activeCount() > 2){
		// //待ちループ
		// }
		// throw new AssertionError("Not Implemented Yet");
	}

	public synchronized void dispatch(Runnable runnable) {
		if (runnable != null) {
			queue.push(runnable);
		}
		throw new AssertionError("Not Implemented Yet");
		// throw new NullPointerException();
	}

	private class LoopThread extends Thread {
		private boolean isActive = true;

		public void run() {

			while (isActive) {
				if (queue.pop() != null) {
					queue.pop().run();
				}
			}
			while (queue.pop() != null) {
				queue.pop().run();
			}
		}

		public void finnish() {
			isActive = false;
		}
	}

}
