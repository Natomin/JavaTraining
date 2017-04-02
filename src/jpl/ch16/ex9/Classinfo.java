package jpl.ch16.ex9;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//クラスの完全な宣言を表示する
public class Classinfo {

	public static void main(String[] args) {

		try {
			Class<?> c = Class.forName(args[0]);

			System.out.println("【Class Name】");
			String name = c.getCanonicalName();
			System.out.println(name);

			System.out.println("【Constractor】");
			List<String> constractor = getSimpleDefinition(getAllConstlantor(c));
			print(constractor);
			System.out.println();

			System.out.println("【Field】");
			List<String> field = getSimpleDefinition(getAllField(c));
			field = getSimpleDefinition(field);
			print(field);
			System.out.println();
		

			System.out.println("【Method】");
			List<String> method = getSimpleDefinition(getAllMethod(c));
			method = getSimpleDefinition(method);
			print(method);
			System.out.println();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void print(Iterable<?> list) {
		for (Object o : list) {
			System.out.println(o.toString());
		}
	}

	public static List<String> getSimpleDefinition(List<String> sample) {
		List<String> convertedStr = new ArrayList<String>();
		for (String s : sample) {
			convertedStr.add(s.replaceAll("([^\\. ]+\\.)*", ""));
		}
		return convertedStr;
	}

	public static List<String> getAllConstlantor(Class<?> type) {
		List<String> constracterList = new ArrayList<String>();
		Constructor<?>[] allConstracter = type.getDeclaredConstructors();
		for (Constructor<?> c : allConstracter) {
			constracterList.add(c.toString());
		}
		return constracterList;
	}

	public static List<String> getAllMethod(Class<?> type) {
		List<String> methodList = new ArrayList<String>();
		Method[] allMethod = type.getDeclaredMethods();
		for (Method m : allMethod) {
			methodList.add(m.toString());
		}
		return methodList;
	}

	public static List<String> getAllField(Class<?> type) {
		List<String> fieldList = new ArrayList<String>();
		Field[] allField = type.getDeclaredFields();
		for (Field f : allField) {
			fieldList.add(f.toString());
		}
		return fieldList;

	}

}
