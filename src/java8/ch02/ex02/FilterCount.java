package java8.ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilterCount {

	public long filterCount(String path, int wordLength) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		// ファイルを文字列へ読み込む
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		// 単語に分割する：文字ではないものが区切り
		return words.stream().filter(w -> {System.out.println(w); return (w.length() > wordLength);}).limit(5).count();
	}


}
