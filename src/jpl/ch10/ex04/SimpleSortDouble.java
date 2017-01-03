package jpl.ch10.ex04;
//今までの練習問題からforループを使用した問題を選んでWhileループを使用して書き直す。
//do-Whileを使用しても書き直すことができるか 
// →できない。（dataのlengthが1の場合は比較できないので先に評価する必要がある）
//そのように書き直すことはあるか、しないとしたらなぜか →しない。
import jpl.ch03.ex11.SortDouble;
public class SimpleSortDouble extends SortDouble {

	@Override
	protected void doSort() {
		int i = 0;
		while (i < getDataLength()) {
			int j = i + 1;
			while (j < getDataLength()) {
				if (compare(i, j) > 0) {
					swap(i, j);
				}
				j++;
			}
			i++;
		}
	}
}
