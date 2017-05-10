package jpl.ch20.ex10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class FileTokenizer {
	private FileReader reader;
	private StreamTokenizer tokenizer;
	private Map<String, Integer> dataMap = new HashMap<String, Integer>();

	public FileTokenizer(FileReader reader) {
		this.reader = reader;
		tokenizer = new StreamTokenizer(reader);
	}

	public void countToken() throws IOException {

		int token = tokenizer.nextToken();
		while (token != StreamTokenizer.TT_EOF) {
			if (token == StreamTokenizer.TT_WORD) {
				// すでにdataMapに登録されているか確認
				if (dataMap.containsKey(tokenizer.sval)) {
					dataMap.put(tokenizer.sval, dataMap.get(tokenizer.sval) + 1);
				}else{
					// 新規追加
					dataMap.put(tokenizer.sval, 1);
				}
			}
			token = tokenizer.nextToken();
		}
	}

	public void printMap() {
		for (Map.Entry<String, Integer> e : dataMap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue() + "回");
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		reader.close();
	}

}
