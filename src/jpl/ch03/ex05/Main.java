package jpl.ch03.ex05;

public class Main {

	public static void main(String[] args) {
		MethodBenchmark benchMark = new MethodBenchmark();
		benchMark.setLoopNum(100);
		long time = benchMark.repeat(1);
		System.out.println("time = " + time);
	}

}
