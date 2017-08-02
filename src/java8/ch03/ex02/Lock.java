package java8.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
	public void withLock(ReentrantLock myLock, Runnable action){
		try{
			action.run();
		}finally {
			myLock.unlock();
		}
	}

}
