package java8.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParallelForLoop {
	public int countLongWord(String path, int wordsNum) throws IOException, InterruptedException {
		Counter counter = new Counter();
		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		// ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		// 単語に分割する：文字ではないものが区切り
		for (String w : words) {
			decision(counter, w, wordsNum);
		}
		Thread.sleep(100);
		return counter.get();
	}

	public static void decision(Counter counter, String w, int wordsNum) {
		new Thread(() -> {
			if (w.length() > wordsNum) {
				counter.count();
			}
		}).start();

	}

}
