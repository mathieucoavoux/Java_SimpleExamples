package objectreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import sun.reflect.ReflectionFactory;

public class ObjectReflection {
	public void printMethod(Method[] myMethod) {
		for (int indM = 0;indM < myMethod.length;indM++) {
			System.out.println("Method name : "+myMethod[indM].getName());
		}
	}
	
	public void getAnnotationSecret() {
		try {
			final Constructor<?> ctor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructors()[0];
			ctor.setAccessible(true);
			/*
			Class myPCls = Class.class;
			Map myPMap = new HashMap();
			Object myNewObj = ctor.newInstance(myPCls,myPMap);
			*/
			
			System.out.println("Class name"+ctor.getName());
			Field[] myFields = ctor.getClass().getDeclaredFields();
			for (int indF = 0;indF < myFields.length;indF++) {
				try {
					System.out.println(myFields[indF].getName());
					//System.out.println("Value :"+myFields[indF].get);
				}catch(Exception e){
					System.out.println(e);
				}
			}
			
				
			//Field mySerial = ctor.getClass().getDeclaredField("serialVersionUID");
			//System.out.println("What is your serial id :"+mySerial.toString());
			/*
			Class[] clsParam = ctor.getParameterTypes();
			for(int indP = 0;indP < clsParam.length;indP++) {
				Method[] met  = clsParam[indP].getDeclaredMethods();
				printMethod(met);
			}
			*/
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void getSecret() {
		try {
			Secret aSecret = new Secret();
			Field[] myFields = aSecret.getClass().getDeclaredFields();
			for (int indF = 0;indF < myFields.length;indF++) {
				try {
					Field myField = myFields[indF];
					myField.setAccessible(true);
					System.out.println("What's your secret ? "+myField.get(aSecret));
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
