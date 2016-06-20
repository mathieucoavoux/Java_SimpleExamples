package objectmap;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FactoryUtils;

public class ObjectFactory {
	public void myFactory() {
		Factory myF = FactoryUtils.instantiateFactory(Bank.class);
		Bank myObj = (Bank) myF.create();
		myObj.setIdBank(14);
		System.out.println("Bank :"+myObj.getIdBank());
		
	}
}
