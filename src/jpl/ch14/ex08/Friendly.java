package jpl.ch14.ex08;

//yieldメソッド呼び出しを追加したら頻度を変更できるか？→できない。
//一方のスレッドが他方のスレッドにCPUサイクルを渡したとしても相互にロックする状態は変わらないため
//同期を解除することなくデッドロックの可能性を取り除く→共通のlockオブジェクトを用いることでデッドロックを回避する
public class Friendly {
	private static final Object lock = new Object();
	private Friendly partner;
	private String name;

	public Friendly(String name) {
		this.name = name;
	}

	public void hug() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "in" + name + ".hug() tryint to invoke "
					+ partner.name + ".hugBack()");
			partner.hugBack();
		}
	}

	private void hugBack() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "in" + name + ".hugBack()");
		}
	}

	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}

}
