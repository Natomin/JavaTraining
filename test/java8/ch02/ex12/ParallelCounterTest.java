package java8.ch02.ex12;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.Test;

public class ParallelCounterTest {
	public Stream<String> getStream(String path) throws IOException{
		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		// ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		// 単語に分割する：文字ではないものが区切り
		return words.stream();
	}

	@Test
	public void test() throws IOException {
		AtomicInteger[] shortWords = ParallelCounter.parallelCount(getStream("./src/java8/ch02/ex01/alice.txt"), 12);
		for(int i = 0; i < shortWords.length; i++){
			System.out.println(i + ":" + shortWords[i]);
		}
	} 
	
	@Test
	public void test2() throws IOException {
		AtomicInteger[] shortWords = ParallelCounter.parallelCount(getStream("./src/java8/ch02/ex01/alice.txt"), 2);
		assertEquals(shortWords[0].get(), 0);
		assertEquals(shortWords[1].get(), 9);
	} 

}
