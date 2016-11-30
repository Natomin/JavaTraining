package jpl.ch06.ex03;
//P104のVerboseインタフェースをenumを使用して再定義する
public interface Verbose {
	enum MessageLevel{
		SILENT,
		TERSE,
		NORMAL,
		VERBOSE,
	}
	
	void setVerbosity(MessageLevel level);
	int getVerbosity();
	
}
