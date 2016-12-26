package jpl.ch07.ex01;
//Unicodeエスケープシーケンスだけを利用して"HelloWorld"プログラムを書く
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("\uFF28" + "\uFF45" + "\uFF4C" + "\uFF4C" + "\uFF4F" + "\uFF0C" 
	+ "\uFF37" + "\uFF4F" + "\uFF52" + "\uFF4C" + "\uFF44");
	}

}
