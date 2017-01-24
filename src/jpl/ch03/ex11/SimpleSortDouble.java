package jpl.ch03.ex11;
//subclassのdoSortで不正をするという意味の問題
//doSort
//データもらう⇒メトリクスをクリア⇒ソート
//①もう一度スーパークラスのsortを呼んでソートすると初期化
//②Probe()を使えばすべてのデータが手に入る⇒データを手に入れてソートしてからsortを呼ぶ
//③メトリクスをオーバーフローさせる（現実的には困難）
public class SimpleSortDouble extends SortDouble{
	@Override
	protected void doSort() {
		for(int i = 0; i < getDataLength(); i++){
			for(int j = i + 1; j < getDataLength(); j++){
				if(compare(i, j) > 0){
					swap(i, j);
				}
			}
		}
	}
}
