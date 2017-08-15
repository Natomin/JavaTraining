package java8.ch01.ex03;

import java.io.File;

public class PrintFiles {
	public void printDir(File file, String suffix) {
		File[] dir = file.listFiles((File f, String name) -> name.endsWith("." + suffix));
		for (File d : dir) {
			System.out.println(d);
		}
	}
	//キャプチャされる変数はsuffix
}
