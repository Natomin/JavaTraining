package jpl.ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X(){
		printX();
		fullMask = xMask;
		printX();
	}
	
	public int maik(int orig){
		return (orig & fullMask);
	}
	public void printX(){
		System.out.printf("(x) xMask:%x  ", xMask);
		System.out.printf("              fullMask:%x%n", fullMask );
	}
}
