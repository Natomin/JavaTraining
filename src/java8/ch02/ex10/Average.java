package java8.ch02.ex10;

import java.util.stream.Stream;

public class Average {
	//countは終端処理だから使用できない
	public static double ave(Stream<Double> stream){
		class Data{
			double sum = 0.0;
			int count = 0;
		}
		
		Data data = stream.reduce(new Data(),
				(d, x) -> {
					d.sum = d.sum + x;
					d.count++;
					return d;
				}, (d1, d2) -> {
					d1.sum = d1.sum + d2.sum;
					d1.count = d1.count + d2.count;
					return d1;
				});
				
		return (data.sum / data.count);
	}

}
