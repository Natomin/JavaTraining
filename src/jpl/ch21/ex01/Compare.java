package jpl.ch21.ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jpl.ch20.ex04.LineOutputStream;

public class Compare {
	private List<String> list = new ArrayList<String>();
	private String file;
	///JavaTraining/src/jpl/ch21/ex01/CompareTextFile
	private LineOutputStream stream;
	
	public Compare(String file) throws FileNotFoundException{
		this.file = file;
		stream = new LineOutputStream(new FileReader(file));
	}
	
	public void comparetext() throws IOException{
		String readData = stream.readLine();
		list.add(readData);
		readData = stream.readLine();
		int i = 0;
		while(list.get(i).compareTo(readData) < 0){
			i++;
		}
		list.add(i, readData);
		
	}

}
