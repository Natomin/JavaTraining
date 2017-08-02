package java8.ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class AsyncProcessing {
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second){
		new Thread(){
			public void run(){
				T result = null;
				try {
					result = first.get();
					second.accept(result, null);
				} catch (Exception e) {
					second.accept(result, e);
				}
			}
		}.start();
	}
	
	//3つ目のパラメーターは必要ない
	//ユースケースはよくわからない・・・

}
