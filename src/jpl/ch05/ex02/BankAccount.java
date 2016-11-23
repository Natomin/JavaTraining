package jpl.ch05.ex02;
//口座に対する最後の１０個の処理を記録するBankAccountを作成する。
//Historyオブジェク返すhistoryメソッドを追加
//Actionオブジェクトを一つ返し、リストの最後ではnullを返すnextメソッドを追加
//BankAccountとHistoryオブジェクトを強く結びつける必要があるのでHistoryはネストしたクラスにする
//エンクロージングオブジェクトのフィールドにアクセスしないのでstaticとする

import java.util.ArrayList;

public class BankAccount {
	private long number;	//講座番号
	private long balance;	//残高（セント）
	private Action lastAct;	//最後に行われた処理
	private History history;

	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + ": " + act + " " + amount;
		}
	}
	public static class History{
		private ArrayList<Action> history = new ArrayList<>();
		private int actIdx = -1;
		
		public void add(Action act){
			if(history.size() < 10){
				history.add(act);
			}else{
				history.remove(0);
				history.add(act);
			}
		}
		
		public Action next(){
			actIdx++;
			if(actIdx < 10){
				return history.get(actIdx);
			}else{
				actIdx = -1;
				return null;
			}
		}
	}
	
	public History history(){
		return history;
	}
	
	public void deposit(long amount){
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add(new Action("deposit", amount));
	}
	
	public void withdraw(long amount){
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.add(new Action("withdraw", amount));
	}
	
	
}
