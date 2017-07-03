package java8.ch01.ex07;

import jpl.ch14.ex08.Friendly;

public class AndThen {
	public static Runnable andThen(Runnable runFirst, Runnable runSecond) {
		return () -> {
			runFirst.run();
			runSecond.run();
		};
	}

	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		andThen((() -> jareth.hug()), (() -> cory.hug())).run();

	}

}
