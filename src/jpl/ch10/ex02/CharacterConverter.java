package jpl.ch10.ex02;
//練習問題10.2で作成したメソッドをswitchを使用して書き直す
public class CharacterConverter {
	public String SpecialCharacterConverter(String str) {
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '\u000C':// フォームフィード\f
				str = str.replace(Character.toString('\u000C'), "\\f");
				break;
			case '\u0009':// タブ\t
				str = str.replace(Character.toString('\u0009'), "\\t");
				break;
			case '\u0008':// バックスペース\b
				str = str.replace(Character.toString('\u0008'), "\\b");
				break;
			default:
				break;
			}
		}
		return str;
	}
}
