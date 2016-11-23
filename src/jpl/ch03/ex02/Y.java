package jpl.ch03.ex02;

public class Y extends X{
	protected int yMask = 0xff00;
	
	public Y(){
		printY();
		fullMask |= yMask;
		printY();
	}
	public void printY(){
		System.out.printf("(y) xMask:%x  ", xMask);
		System.out.printf(" yMask:%x  ", yMask);
		System.out.printf(" fullMask:%x%n", fullMask );
	}
}
