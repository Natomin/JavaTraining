package java8.ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ExecutionSpeed {
	public void countLongWords(String path, int wordLength) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		// ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		// 単語に分割する：文字ではないものが区切り
		words.stream().filter(w -> w.length() > wordLength).count();
		
	}
	
	public void countLongWordsParallel(String path, int wordLength) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		// ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		// 単語に分割する：文字ではないものが区切り
		words.parallelStream().filter(w -> w.length() > wordLength).count();
	}
	
	public static void main(String[] args) throws IOException {
		long beforeTime = System.nanoTime();
		new ExecutionSpeed().countLongWords("./src/java8/ch02/ex01/alice.txt", 12);
		long afterTime = System.nanoTime();
		System.out.println("not parallel: " + (afterTime - beforeTime));
		
		beforeTime = System.nanoTime();
		new ExecutionSpeed().countLongWordsParallel("./src/java8/ch02/ex01/alice.txt", 12);
		afterTime = System.nanoTime();
		System.out.println("    parallel: " + (afterTime - beforeTime));
	}

}
