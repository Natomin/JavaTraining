package jpl.ch06.ex05;
//getColorをabstractとしてenumが正しいSignalColorオブジェクトを返すように定数固有のメソッドを定義する。
//定数固有のメソッドを定義する使用することを推奨するか→6.4と比べて利点が見つからないのでこの場合では推奨しない。
public enum SignalColor {
	RED {
		@Override
		SignalColor getColor() {
			return this;
		}
	},
	YELLOW {
		@Override
		SignalColor getColor() {
			return this;
		}
	},
	GREEN {
		@Override
		SignalColor getColor() {
			return this;
		}
	};
	
	abstract SignalColor getColor();

}
