package jpl.ch05.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch05.ex02.BankAccount.Action;
import jpl.ch05.ex02.BankAccount.History;

public class BankAccountTest {

	@Test
	public void test() {
		BankAccount account = new BankAccount();
		long[] testData = {1000,1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500};
		for(int i = 0; i < testData.length; i++){
			account.deposit(testData[i]);	
		}

		History history = account.history();
		Action action = history.next();
		//historyに保存できるのは10個までなので最初の2つのデータが消えていることを確認する
		for(int i = (testData.length - 10); i < testData.length; i++){
			//testDataと一致しているか確認
			assertEquals("0: deposit " + testData[i], action.toString());
			action = history.next();
		}
		//nextメソッドがリストの最後でnullを返すことを確認
		assertNull(action);
		
		
	}

}
