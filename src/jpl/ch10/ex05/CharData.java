package jpl.ch10.ex05;
//二つのcharを引数に取り、それらの文字とそれらの文字間の文字を表示するメソッドを書く。
public class CharData {
	public void printCharLine(char first, char last){
		for(char n = first; n <= last; n++){
			System.out.println(n);
		}
	}

}
