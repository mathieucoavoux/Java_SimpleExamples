package objectreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflectionHandler {
	public static void main(String args[]) {
		ObjectReflection objR = new ObjectReflection();
		objR.getSecret();
		objR.getAnnotationSecret();
	}
}
