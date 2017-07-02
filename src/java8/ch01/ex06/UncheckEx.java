package java8.ch01.ex06;

public class UncheckEx {
	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		};
	}

	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			System.out.println(" (´o｀)");
			Thread.sleep(1000);
			System.out.println(" (´ρ｀)zzZ");
		})).start();
	}

}
