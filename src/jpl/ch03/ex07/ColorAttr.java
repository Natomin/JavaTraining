package jpl.ch03.ex07;
//equalsとhashCodeをオーバーライドする

//スーパークラスのtoStringメドッドをオーバーライドしていないのでこのままだとequalsメソッドは色が違ってもturueになってしまう。
//nameとvakueとmyColorの３つのフィールドを比較する必要がある
//まず型チェックする（自分のクラスと同じインスタンスじゃなかったらfalse）型が一緒だったら３つのフィールドを比較
//
public class ColorAttr extends Attr{
	private ScreenColor myColor;
	
	public boolean equals(Object obj){//オーバーライド
		if(this.toString().equals(obj.toString())){
			return true;
		}else{
			return false;
		}
	}
	
	public int hashCode(){//オーバーライド
		int resreturn = myColor.hashCode() * 2;
		return resreturn;
	}

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}
	public ColorAttr(String name) {
		super(name, "transparent");
		decodeColor();
	}
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor() {
		return myColor;
	}

	protected void decodeColor(){
		if(getValue() == null){
			myColor = null;
		}else{
			myColor = new ScreenColor(getValue());
		}
	}
	
	
}
