package java8.ch02.ex12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelCounter {
	
	public static AtomicInteger[] parallelCount(Stream<String> words, int wordLength){
		AtomicInteger[] shortWords = new AtomicInteger[wordLength];
		
		for(int i = 0; i < shortWords.length; i++){
			shortWords[i] = new AtomicInteger();
		}
		
		words.parallel().forEach(s -> {
			if(s.length() < wordLength){
				shortWords[s.length()].getAndIncrement();
				//System.out.println(s);
			}
		});
		return shortWords;
	}

}
