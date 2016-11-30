package jpl.ch03.ex12;


public class Student {
	private final int age;
	private final int height;
	private final String name;
	
	public Student(String name, int hight, int age){
		this.name = name;
		this.height = hight;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public int getHight() {
		return height;
	}

	public String getName() {
		return name;
	}
	public String toString(){
		return " name:" + name + " age:" + age + " height:" + height;
	}

}
