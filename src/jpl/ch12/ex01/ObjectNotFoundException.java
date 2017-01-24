package jpl.ch12.ex01;
//LinkedListクラスに対するObjectNotFoundExceptionクラスを作成する。
//リスト中のオブジェクトを探すfindメソッドは要求されたオブジェクトを持つNodeを返すか、なければこの例外を投げる
//何か付け加えるとしたらどのような追加データを保持するべきか
//->要求されたオブジェクト
public class ObjectNotFoundException extends Exception{
	public final Object data;
	public ObjectNotFoundException(Object data){
		super("No data \"" + data.toString() + "\" is found");
		this.data = data;
	}
}
