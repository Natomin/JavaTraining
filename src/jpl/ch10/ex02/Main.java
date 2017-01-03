package jpl.ch10.ex02;

public class Main {

	public static void main(String[] args) {
		CharacterConverter converter = new CharacterConverter();
		System.out.println(converter.SpecialCharacterConverter("aaa\tbbbccc" + Character.toString('\u0009')));
		System.out.println(converter.SpecialCharacterConverter("aaa\bbbbccc" + Character.toString('\u0008')));
		System.out.println(converter.SpecialCharacterConverter("aaa\fbbbccc" + Character.toString('\u000C')));
	}

}
