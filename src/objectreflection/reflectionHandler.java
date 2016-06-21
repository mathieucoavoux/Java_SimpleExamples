package objectreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflectionHandler {
	public static void main(String args[]) {
		ObjectReflection objR = new ObjectReflection();
		System.out.println("**************************");
		System.out.println("getPrivateField");
		objR.getPrivateField();
		System.out.println("**************************");
		System.out.println("getPrivateMethod");
		objR.getPrivateMethod();
		System.out.println("**************************");
		System.out.println("getPrivateConstructor");
		objR.getPrivateConstructor();
		System.out.println("**************************");
	}
}
