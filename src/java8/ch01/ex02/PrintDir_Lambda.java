package java8.ch01.ex02;

import java.io.File;

public class PrintDir_Lambda {
	public void printDir(File file) {
		File[] dir = file.listFiles((File f) -> f.isDirectory());
		for (File d : dir) {
			System.out.println(d);
		}
	}
}
