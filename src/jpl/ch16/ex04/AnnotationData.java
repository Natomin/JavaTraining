package jpl.ch16.ex04;



public class AnnotationData {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printAnnotation(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	public static void printAnnotation(Class<?> c) {
		java.lang.annotation.Annotation[] annotation = c.getAnnotations();
		for (java.lang.annotation.Annotation a : annotation) {
			String decl = a.toString();
			System.out.println(" ");
			System.out.println("Annotation:" + decl);
		}
	}

}
