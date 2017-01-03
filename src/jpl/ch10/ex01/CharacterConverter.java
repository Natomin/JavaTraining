package jpl.ch10.ex01;
//文字列のパラメーターを取り、その文字列中のすべての特殊文字を対応するJava言語の表現で置き換えた文字列を
//返すメソッドをif-elseを使用して書く。
public class CharacterConverter {
	 
	public String SpecialCharacterConverter(String str){
		if(str.contains("\"")){//ダブルクオート\"
			return str.replace("\"", "\\\"");
		}else if(str.contains("\u0027")){//シングルクオート\'
			return str.replace("\u0027", "\\\'");
		}else if(str.contains("\n")){//改行\n
			return str.replace("\n", "\\n");
		}else if(str.contains("\u0009")){//タブ\t
			return str.replace("\u0009", "\\t");
		}else if(str.contains("\u0008")){//バックスペース\b
			return str.replace("\u0008", "\\b");
		}else if(str.contains("\r")){//復帰\r
			return str.replace("\r", "\\r");
		}else if(str.contains("\f")){//フォームフィード\f
			return str.replace("\f", "\\f");
		}else if(str.contains("\\")){//バックスラッシュ\\
			return str.replace("\\", "\\\\");
		}
		return str;
	}
}
