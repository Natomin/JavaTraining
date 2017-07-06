package jpl.ch22.ex12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.regex.Pattern;
import jpl.ch22.ex04.Attributed;
import jpl.ch22.ex04.Attr;

public class AttrReader {
	public static Attributed readAttrs(Reader source) throws IOException{
		AttributedImpl attrs = new AttributedImpl();
		Scanner in = new Scanner(source);
		Pattern pat = Pattern.compile("(.*)=(.*)");
		
		while(in.hasNext()){
			if(in.hasNext(pat)){
				String[] vals = in.findWithinHorizon(pat, 0).split("=");
				in.nextLine();
				if(vals.length == 2){
					attrs.add(new Attr(vals[0], vals[1]));
				}else{
					in.close();
					throw new IOException("bad data");
				}
			}
		}
		in.close();
		return attrs;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		AttributedImpl attrs = (AttributedImpl) AttrReader.readAttrs(new FileReader("./src/jpl/ch22/ex12/AttrText.txt"));
		for(Attr a : attrs){
			System.out.println(a.toString());
		}
	}
}
