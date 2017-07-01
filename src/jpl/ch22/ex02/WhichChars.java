package jpl.ch22.ex02;

import java.util.HashSet;

public class WhichChars {

	private HashSet<Character> used = new HashSet<>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			used.add(str.charAt(i));
		}
	}

	@Override
	public String toString() {
		String desc = "[";
		for (Character c : used) {
			desc = desc + c;
		}
		return desc + "]";
	}
}
