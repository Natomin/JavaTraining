package jpl.ch13.ex03;
//一つの入力文字列に区切られたすべての文字列を取り出して配列にして返すdelimitedStringメソッドを作成する。
public class StringFormatter {

	public String[] delimitedString(String from, char start, char end){
		String[] sub = new String[from.length()];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = "0";
		}
		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end, startPos);
		if(startPos == -1){
			return null;
		}
		for(int i = 0; i < from.length(); i++){
			if(startPos == -1){
				String[] subString = new String[i + 1];
				System.arraycopy(sub, 0, subString, 0, i + 1);
				return subString;
			}else if(endPos == -1){
				sub[i] = from.substring(startPos);
				String[] subString = new String[i + 1];
				System.arraycopy(sub, 0, subString, 0, i + 1);
				return subString;
			}else {
				sub[i] = from.substring(startPos, endPos + 1);
				startPos = from.indexOf(start, endPos + 1);
				endPos = from.indexOf(end, startPos);
			}
		}
		return sub;
	}
}
