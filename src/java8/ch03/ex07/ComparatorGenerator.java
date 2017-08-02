package java8.ch03.ex07;

import java.util.Comparator;

enum Condition {
	DESCENDING_ORDER, NO_DISTINCTION_CASE, NO_DISTINCTION_SPACE
}

public class ComparatorGenerator {

	public Comparator<String> generateComparator(Condition... conditions) {
		return (first, second) -> {
			boolean order = true;
			boolean distinction_case = true;
			for (Condition c : conditions) {
				switch (c) {
				case DESCENDING_ORDER:
					order = false;
					break;
				case NO_DISTINCTION_CASE:
					distinction_case = false;
					break;
				case NO_DISTINCTION_SPACE:
					// スペースを削除する
					first = first.replaceAll(" ", "");
					second = second.replaceAll(" ", "");
					break;
				default:
					break;
				}
			}
			if (order) {
				return distinction_case ? first.compareTo(second) : first.compareToIgnoreCase(second);
			} else {
				return distinction_case ? second.compareTo(first) : second.compareToIgnoreCase(first);
			}
		};
	}

}
