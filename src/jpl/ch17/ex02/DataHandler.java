package jpl.ch17.ex02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file) {
		byte[] data;

		// lastFile、lastDataを記憶しているか調べる
		if (lastFile != null && file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null) {
				return data;
			}
		}
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		;
		lastData = new WeakReference<byte[]>(data);
		return data;

	}

	private byte[] readBytesFromFile(File file) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
