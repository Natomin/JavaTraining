package jpl.ch01.ex16;

import java.io.IOException;

public class BadDataSetExeption extends Exception{
	private String file;
	private IOException e;
	public BadDataSetExeption(String file, IOException e){
		this.file = file;
		this.e = e;
	}

	public Throwable getException(){
		return e;
	}
	
	public String getFileName(){
		return file;
	}
}
