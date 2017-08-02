package java8.ch03.ex17;


import java.util.function.Consumer;

import org.junit.Test;

import javafx.scene.image.Image;

public class AsyncProcessingTest {

	@Test
	public void test() {
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				Image image = new Image("file:aaa");
				System.out.println("run1");
			}
		};

		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("run2");
			}
		};
		AsyncProcessing.doInParallelAsync(run1, run2, new Consumer<Throwable>() {
			
			@Override
			public void accept(Throwable t) {
				System.out.println(t.getMessage());
			}
		});
	}

}
