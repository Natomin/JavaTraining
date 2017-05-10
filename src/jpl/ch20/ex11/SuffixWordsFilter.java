package jpl.ch20.ex11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixWordsFilter implements FilenameFilter {
	private String suffix;

	public SuffixWordsFilter(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {
		return (!name.endsWith(suffix));
	}

	public static void main(String[] args) {
		String suffix = ".DS_Store";
		SuffixWordsFilter filter = new SuffixWordsFilter(suffix);
		File dir = new File("/Users/fujimuranatsumi/Documents/workspace/JavaTraining/src/jpl/ch20");
		String[] fileList = dir.list();
		for (String fileName : fileList) {
			if (filter.accept(dir, fileName)) {
				continue;
			}
			System.out.println(fileName);
		}
	}

}
