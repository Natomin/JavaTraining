package jpl.ch21.ex02;
import java.util.WeakHashMap;
import java.io.File;

public class DataHandler {
	private WeakHashMap<File, byte[]> lastData = new WeakHashMap<>();// 最後に読んだファイルとデータ
	byte[]readFile(File file){
	byte[]data;
	// ファイルを記憶しているか調べる
	if(lastData.containsKey(file)){
	data = lastData.get(file);
	if(data != null)
	return data;
	}
	// 記憶していないので、読み込む
	data = readBytesFromFile(file);
	lastData.put(file, data);
	return data;
	}
	
	private byte[] readBytesFromFile(File file) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	

}
