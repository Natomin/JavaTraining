package jpl.ch24.ex01;

import java.util.ResourceBundle;

import org.junit.Test;

public class GlobalHehhoTest {

	@Test
	public void test_default() {
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		System.out.println("test for GlobalRes");
		String msg;
		msg = res.getString(GlobalRes.GOODBYE);
		System.out.println(msg);
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
		System.out.println();
	}

	@Test
	public void test_en() {
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes_en");
		System.out.println("test for GlobalRes_en");
		String msg;
		msg = res.getString(GlobalRes.GOODBYE);
		System.out.println(msg);
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
		System.out.println();
	}
	
	@Test
	public void test_en_AU() {
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes_en_AU");
		System.out.println("test for GlobalRes_en_AU");
		String msg;
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
		System.out.println();
	}
	
	@Test
	public void test_ar() {
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes_ar");
		System.out.println("test for GlobalRes_ar");
		String msg;
		msg = res.getString(GlobalRes.GOODBYE);
		System.out.println(msg);
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
		System.out.println();
	}
	
	@Test
	public void test_fr() {
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes_fr");
		System.out.println("test for GlobalRes_fr");
		String msg;
		msg = res.getString(GlobalRes.GOODBYE);
		System.out.println(msg);
		msg = res.getString(GlobalRes.HELLO);
		System.out.println(msg);
		System.out.println();
	}
}
