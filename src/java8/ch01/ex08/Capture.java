package java8.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class Capture {

	public static void main(String[] args) {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		//各ラムダ式は異なる値をキャプチャする
		
		for(int i = 0;i < names.length; i++){
			String name = names[i];
			runners.add(() -> System.out.println(name));
			//runners.add(() -> System.out.println(names[i])); 　←names[i]できない
			//ローカル変数に値を持たせれば実行できる
		}
		
		for (Runnable runner : runners) {
			runner.run();
		}
	}
	
	

}
