package jpl.ch03.ex11;
//ソートアルゴリズムが気づかれることなくメトリックすに対して不正を行えるSortDoubleのセキュリティホールを見つけて修正する
public class SortMetrics implements Cloneable{

	//修正前→publicのためソートアルゴリズムから直接書き換え可能
//	public long prebeCnt,	//単純なデータの値調査
//				compareCnt,	//２つの要素の比較
//				swapCnt;	//２つ要素の交換
	
	//修正後→privateにして直接書き換えできないように修正
	private long prebeCnt,	//単純なデータの値調査
	compareCnt,	//２つの要素の比較
	swapCnt;	//２つ要素の交換
	
	public final void incrementPrebeCnt(){
		prebeCnt++;
	}
	public final void incrementCompareCnt(){
		compareCnt++;
	}
	public final void incrementSwapCnt(){
		swapCnt++;
	}
	
	public void init(){
		prebeCnt = compareCnt = swapCnt = 0;
	}
	
	public String toString(){
		return prebeCnt + "prebeCnt" +
				compareCnt + "compareCnt" +
				swapCnt + "swapCnt";
	}
	
	public SortMetrics clone(){
		try {
			return (SortMetrics)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
