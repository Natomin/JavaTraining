package jpl.ch03.ex12;

public class SortMetrics {
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
