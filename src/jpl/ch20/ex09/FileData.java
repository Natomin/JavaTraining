package jpl.ch20.ex09;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileData {
	File file;

	public FileData(String filePath) {
		file = new File(filePath);
	}

	public void printInfo(){
		System.out.println("ファイル名:" + file.getName());
		System.out.println("ファイルの存在:" + file.exists());
		System.out.println("読み込み可能:" + file.canRead());
		System.out.println("書き込み可能:" + file.canWrite());
		System.out.println("絶対パス:" + file.isAbsolute());
		 //最終更新日時表示書式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //最終更新日時取得＆表示
		System.out.println("最終修正時刻:" + sdf.format(file.lastModified()));
		System.out.println("ファイル長:" + file.length() + "byte");
	}
}
