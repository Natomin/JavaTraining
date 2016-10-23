package jpl.ch02.ex18;
//コマンドラインで指定された名前を所有者として持つくるまを作成して、表示する
public class Main {

	public static void main(String[] args) {
		Vehicle[] car = new Vehicle[] {new Vehicle(), new Vehicle(), new Vehicle()};
		
//		String[] name = new String[] {"aaa", "bbb", "ccc"};
//		for(int i = 0; i < car.length; i++){
//			car[i].setDriverName(name[i]);
//			car[i].printName();
//		}
		
		for(int i = 0; i < args.length; i++){
			car[i].setDriverName(args[i]);
			car[i].printName();
		}
	}
}
