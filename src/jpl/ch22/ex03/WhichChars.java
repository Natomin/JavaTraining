package jpl.ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {

	private HashMap<Byte, BitSet> bitSetMap = new HashMap<>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = (str.charAt(i));
			byte hi = (byte) (c >> 8);
			BitSet set = bitSetMap.get(hi);
			if (set == null) {
				set = new BitSet();
			}
			set.set(c);
			bitSetMap.put(hi, set);
		}
	}

	@Override
	public String toString() {
		String desc = "[";
		for (byte k : bitSetMap.keySet()) {
			BitSet used = bitSetMap.get(k);
			for (int i = used.nextSetBit(0); i >= 0; i = used.nextSetBit(i + 1)) {
				desc = desc + (char) i;
			}
		}
		return desc + "]";
	}

}
