package jpl.ch13.ex01;
//文字列中に指定された文字が出現する回数を数えるメソッドを書く
public class CharCounter {
	public int countChar(String str, char ch){
		int cnt = 0;
		if(str.indexOf(ch) < 0){
			return cnt;
		}else{
			int idx = str.indexOf(ch);
			while(idx >= 0){
				cnt++;
				idx = str.indexOf(ch, idx + 1);				
			}
			return cnt;
		}
	}
}
