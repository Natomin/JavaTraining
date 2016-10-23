package jpl.ch02.ex06;

import jpl.ch02.ex02.Linked_List;
import jpl.ch02.ex05.Vehicle;

public class Main {

	public static void main(String[] args) {
		Linked_List list = new Linked_List();
		Vehicle car1 = new Vehicle();
		Vehicle.nextID++;
		car1.driverName = "aaa";
		list.add(car1);
		Vehicle car2 = new Vehicle();
		Vehicle.nextID++;
		car2.driverName = "bbb";
		list.add(car2);
		Vehicle car3 = new Vehicle();
		Vehicle.nextID++;
		car3.driverName = "ccc";
		list.add(car3);
		
		Vehicle[] car = new Vehicle[3];
		int i = 0;
		if(list.head.data == null){//リストの確認用テストコード
			System.out.println("dataがありません");
		}else{
			list.prev = list.head;
			car[i] = (Vehicle)list.prev.data;
			System.out.println(car[i].id);
			System.out.println(car[i].driverName);
			i++;
			while(list.prev.next != null){
				list.prev = list.prev.next;
				car[i] = (Vehicle)list.prev.data;
				System.out.println(car[i].id);
				System.out.println(car[i].driverName);
				i++;
			}
		}
	}

}
