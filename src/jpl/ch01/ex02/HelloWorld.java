package jpl.ch01.ex02;
//コードを一部変更してどのようなエラーが出るか調べる

public class HelloWorld {
	public static void main(String[] args) {//アクセス修飾子をprivateに変更すると、メインメソッドが見つけられないエラー
		System.out.println("Hello, world");//「;」を削除すると「構文エラー」
	}
}
