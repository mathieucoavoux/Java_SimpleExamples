package objectmap;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapHandler {
	public static void StringEntriesMap() {
		Map m1 = new HashMap();
		m1.put("Bank1", "BNP");
		m1.put("Bank2", "ANZ");
		m1.put("Bank3", "HSBC");
		System.out.println("Entries :"+m1);
	}
	
	public static void ObjectEntriesMap() {
		Map m2 = new HashMap();
		System.out.println("Empty map :"+m2);
		Bank bank1 = new Bank();
		bank1.setIdBank(12);
		m2.put("Bank1", bank1);
		System.out.println("Map with object :"+m2);
		Bank bank2 = (Bank) m2.get("Bank1");
		System.out.println("Entries :"+bank2.getIdBank());
	}
	public static void main(String args[]) {
		StringEntriesMap();
		ObjectEntriesMap();
		ObjectFactory objFactory = new ObjectFactory();
		objFactory.myFactory();
		ObjectLazy objLazy = new ObjectLazy();
		objLazy.objectConverter();
	}
}
