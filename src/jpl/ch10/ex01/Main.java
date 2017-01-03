package jpl.ch10.ex01;

public class Main {

	public static void main(String[] args) {
		CharacterConverter converter = new CharacterConverter();
		System.out.println(converter.SpecialCharacterConverter("aaa\nbbbccc"));
		System.out.println(converter.SpecialCharacterConverter("aaa\tbbbccc" + "\u0009"));
		System.out.println(converter.SpecialCharacterConverter("aaa\bbbbccc" + "\u0008"));
		System.out.println(converter.SpecialCharacterConverter("aaa\rbbbccc" ));
		System.out.println(converter.SpecialCharacterConverter("aaa\fbbbccc" ));
		System.out.println(converter.SpecialCharacterConverter("aaa\\bbbccc" ));
		System.out.println(converter.SpecialCharacterConverter("aaa\'bbbccc" + "\u0027"));
		System.out.println(converter.SpecialCharacterConverter("aaa\"bbbccc" ));
		
	}

}
