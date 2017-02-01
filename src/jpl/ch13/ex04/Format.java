package jpl.ch13.ex04;

import java.util.ArrayList;

public class Format {
	public ArrayList<Object> formatConversion(String data) {
		String[] splitData = data.split("[\n ]");
		ArrayList<Object> list = new ArrayList<Object>();
		String value;
		for (int i = 0; i < splitData.length; i++) {
			if (i % 2 == 0) {
				switch (splitData[i]) {
				case "Boolean":
					value = splitData[i + 1];
					list.add(Boolean.parseBoolean(value));
					break;

				case "Character":
					value = splitData[i + 1];
					list.add(value.charAt(0));
					break;
					
				case "Byte":
					value = splitData[i + 1];
					list.add(Byte.parseByte(value));
					break;

				case "Short":
					value = splitData[i + 1];
					list.add(Short.parseShort(value));
					break;

				case "Integer":
					value = splitData[i + 1];
					list.add(Integer.parseInt(value));
					break;

				case "Long":
					value = splitData[i + 1];
					list.add(Long.parseLong(value));
					break;

				case "Float":
					value = splitData[i + 1];
					list.add(Float.parseFloat(value));
					break;
					
				case "Double":
					value = splitData[i + 1];
					list.add(Double.parseDouble(value));
					break;
				case "String":
					value = splitData[i + 1];
					list.add(value);
					break;

				default:
					System.out.println("default");
					return null;
				}
			}
		}
		return list;
	}

}
