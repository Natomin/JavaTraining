package jpl.ch13.ex04;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FormatTest {

	@Test
	public void test1() {
		Format format = new Format();
		int[] testCase = { 10, 20, 30 };
		String data = "Integer 10\nInteger 20\nInteger 30\n";
		ArrayList<Object> list = format.formatConversion(data);
		for (int i = 0; i < list.size(); i++) {
			int value = (int) list.get(i);
			assertTrue(testCase[i] == value);
			System.out.println(value);
		}
	}

	@Test
	public void test2() {
		Format format = new Format();
		String type = "Double";
		String data = "";
		double[] testCase = { 10.5, 20.5, 30.5 };
		for (int i = 0; i < testCase.length; i++) {
			data = data + type + " " + testCase[i] + "\n";
		}
		ArrayList<Object> list = format.formatConversion(data);
		for (int i = 0; i < list.size(); i++) {
			double value = (double) list.get(i);
			assertTrue(testCase[i] == value);
			System.out.println(value);
		}
	}

	@Test
	public void test3() {
		Format format = new Format();
		String type = "Float";
		String data = "";
		double[] testCase = { 10.6f, 20.6f, 30.6f };
		for (int i = 0; i < testCase.length; i++) {
			data = data + type + " " + testCase[i] + "\n";
		}
		ArrayList<Object> list = format.formatConversion(data);
		for (int i = 0; i < list.size(); i++) {
			float value = (float) list.get(i);
			assertTrue(testCase[i] == value);
			System.out.println(value);
		}
	}

	@Test
	public void test4() {
		Format format = new Format();
		String type = "Boolean";
		String data = "";
		boolean[] testCase = { true, true, false };
		for (int i = 0; i < testCase.length; i++) {
			data = data + type + " " + testCase[i] + "\n";
		}
		ArrayList<Object> list = format.formatConversion(data);
		for (int i = 0; i < list.size(); i++) {
			boolean value = (boolean) list.get(i);
			assertTrue(testCase[i] == value);
			System.out.println(value);
		}
	}
}
