package jpl.ch17.ex03;

//ハッシュコードを使用する代わりにキーを管理することで参照オブジェクトをす用するように、リソース実装クラスを書き直す
import java.lang.ref.WeakReference;

public class ResourceImpl implements Resource {
	private final WeakReference<Object> key;
	boolean needsRelease = false;

	public ResourceImpl(Object key) {
		this.key = new WeakReference<Object>(key);
		// ..外部リソースの設定...

		needsRelease = true;
	}

	@Override
	public void use(Object key, Object... args) {
		if (this.key.get() != key) {
			throw new IllegalArgumentException("wrong key");
		}
		// ..リソースの使用...
	}

	@Override
	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;

			// ..リソースの解放...
		}
	}

}
