package objectreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import sun.reflect.ReflectionFactory;

public class ObjectReflection {
	
	public void getPrivateMethod() {
		int exAccess;
		Class secretClass = Secret.class;
		Method[] myMethod = secretClass.getDeclaredMethods();
		try {
			Object myObject = secretClass.newInstance();
			for (int indM = 0;indM < myMethod.length;indM++) {
				exAccess= 0;
				Method currentMethod = myMethod[indM];
				System.out.println("First try with Java security");
				try {
					String myResString = (String) currentMethod.invoke(myObject);
					System.out.println("Result : "+myResString);
				}catch(IllegalAccessException IAE) {
					System.out.println("Private method can not be invoked");
					exAccess = 1;
				}catch(Exception e){
					System.out.println(e);
				}
				System.out.println("Method name : "+myMethod[indM].getName());
				if (exAccess == 1 ) {
					System.out.println("Second try without Java security");
					currentMethod.setAccessible(true);
					try {
						String myResString = (String) currentMethod.invoke(myObject);
						System.out.println("Result : "+myResString);
					}catch(IllegalAccessException IAE) {
						System.out.println("Private method can not be invoked");
						exAccess = 1;
					}catch(Exception e){
						System.out.println(e);
					}
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void getPrivateConstructor() {
		System.out.println("First try with Java security");
		try {
			//Tries to create a new instance of a private class
			Class pubClass = PublicSecret.class;
			Object secIns = pubClass.newInstance();
		}catch(IllegalAccessException IAE) {
			System.out.println("Private class can not be instanciated");
		}catch(Exception e) {
			System.out.println("Unhandled exception"+e);
		}
		System.out.println("Second try without Java security");
		try {
			//Suppress Java checks to force the private class instance creation
			Class pubClass = PublicSecret.class;
			Constructor secConst = pubClass.getDeclaredConstructor();
			secConst.setAccessible(true);
			PublicSecret hotSecret = (PublicSecret) secConst.newInstance();
		}catch(IllegalAccessException IAE) {
			System.out.println("Private class can not be instanciated");
		}catch(Exception e) {
			System.out.println("Unhandled exception"+e);
		}
		
	}
	
	public void getPrivateField() {
		System.out.println("First try with Java security");
		try {
			int exAccess;
			Secret aSecret = new Secret();
			Field[] myFields = aSecret.getClass().getDeclaredFields();
			for (int indF = 0;indF < myFields.length;indF++) {
				exAccess= 0;
				Field myField = myFields[indF];
				try {
					System.out.println("What's your secret ? "+myField.get(aSecret));
				}catch(IllegalAccessException IAE) {
					System.out.println("Can not get value of private field");
					exAccess = 1;
				}catch (Exception e) {
					System.out.println(e);
				}
				if (exAccess == 1 ) {
					myField.setAccessible(true);
					System.out.println("Second try without Java security");
					try {
						System.out.println("What's your secret ? "+myField.get(aSecret));
					}catch(IllegalAccessException IAE) {
						System.out.println("Can not get value of private field");
						exAccess = 1;
					}catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
