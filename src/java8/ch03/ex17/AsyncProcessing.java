package java8.ch03.ex17;

import java.util.function.Consumer;

public class AsyncProcessing {
	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler){
		new Thread(){
			public void run(){
				try {
					first.run();
				} catch (Exception e) {
					handler.accept(e);
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				try {
					second.run();
				} catch (Throwable e) {
					handler.accept(e);
				}
			}
		}.start();
	}

}
