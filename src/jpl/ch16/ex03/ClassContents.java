package jpl.ch16.ex03;

import java.lang.reflect.Member;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMenbers(c, c.getFields());
			printMenbers(c.getDeclaredFields());
			printMenbers(c, c.getConstructors());
			printMenbers(c.getDeclaredConstructors());
			printMenbers(c, c.getMethods());
			printMenbers(c.getDeclaredMethods());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	public static void printMenbers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class) {
				continue;
			}
			String decl = m.toString();
			System.out.println(" ");
			System.out.println(decl);
		}
	}

	public static void printMenbers(Class<?> c, Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class) {
				continue;
			} else if (m.getDeclaringClass() == c) {
				continue;
			}

			String decl = m.toString();
			System.out.println(" ");
			System.out.println(decl);
		}
	}


}
