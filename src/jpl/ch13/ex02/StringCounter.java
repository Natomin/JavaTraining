package jpl.ch13.ex02;
//文字列中に指定された文字列が出現する回数を数えるメソッドを書く
public class StringCounter {
	public int countString(String str, String keyWords){
		int cnt = 0;
		if(str.indexOf(keyWords) < 0){
			return cnt;
		}else{
			int idx = str.indexOf(keyWords);
			while(idx >= 0){
				cnt++;
				idx = str.indexOf(keyWords, idx + 1);				
			}
			return cnt;
		}
	}

}
