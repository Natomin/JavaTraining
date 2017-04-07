/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 *
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {
	private boolean isStart;
	private Queue queue;
	private LoopThread[] thread;

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		queue = new Queue(queueSize);
		thread = new LoopThread[numberOfThreads];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new LoopThread();
		}
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {

		synchronized (this) {
			if (isStart) {
				throw new IllegalStateException();
			}
			isStart = true;
		}
		for (LoopThread l : thread) {
			l.start();
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public synchronized void stop() {
		if (!isStart) {
			throw new IllegalStateException();
		}
		for (LoopThread l : thread) {
			l.finnish();
		}
		int activeCount;
		do{
			activeCount = 0;
			for(LoopThread l : thread){
				if(l.isAlive()){
					activeCount++;
				}
			}
		} while (activeCount > 0);
		
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (!isStart) {
			throw new IllegalStateException();
		}
		if (runnable != null) {
			queue.push(runnable);
		} else {
			throw new NullPointerException();
		}
	}

	private class LoopThread extends Thread {
		private boolean isActive = true;

		public void run() {

			Runnable task;
			while (((task = queue.pop()) != null) || isActive) {
				if (task != null) {
					task.run();
				}
			}
		}

		public void finnish() {
			isActive = false;
		}
	}

}
