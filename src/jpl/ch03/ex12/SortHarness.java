package jpl.ch03.ex12;

import java.util.Comparator;

//どのようなオブジェクト型もソートできる一般的なSortHarnessクラスを作成する
//オブジェクトの順序を表す方法をどのように提示しますか→Comparatorクラスを実装した別のクラスで渡す
public class SortHarness {
	public Object[] Sort(Comparator<Object> comparator, Object[] data){
		
		for(int i = 0; i < data.length; i++){
			for(int j = i + 1; j < data.length; j++){
				Object tmp;
				if(comparator.compare(data[i], data[j]) < 0){
					tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}	
		}
		return data;
	}





}
