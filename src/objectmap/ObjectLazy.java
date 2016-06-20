package objectmap;

import java.util.*;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.map.LazyMap;
//commmons-lang-2.6.jar
import org.apache.commons.lang.StringUtils;

public class ObjectLazy {

	public void objectConverter() {
		// Create a Transformer to convert object to XML
		Transformer objectToXML = new Transformer( ) {
		    public Object transform( Object object ) {
		        //Cast input object to ObjectXML
		    	ObjectXML myObjectXML = (ObjectXML) object;
		    	String myXMLString = "<"+myObjectXML.getTag()+"><"+myObjectXML.getElement()
		    							+">"+myObjectXML.getKey()+"</"+myObjectXML.getElement()
		    							+"></"+myObjectXML.getTag()+">";
		    	Object myRetObj = (Object) myXMLString;
		    	return myRetObj;
		    }
		};

		// Create a LazyMap called lazyNames, which uses the above Transformer
		Map myMap = new HashMap( );
		System.out.println("Empty map :"+myMap);
		Map lazyConvert = LazyMap.decorate( myMap, objectToXML );
		
		System.out.println("Lazy convert map :"+lazyConvert);
		// Get and print two names
		ObjectXML theObject = new ObjectXML();
		theObject.setTag("country");
		theObject.setElement("state");
		theObject.setKey("city");
		String myXMLString = (String) lazyConvert.get( theObject );
		System.out.println( "Pattern : " + myXMLString );
		System.out.println("Same thing with transform avoiding the map");
		String myTString = (String) objectToXML.transform(theObject);
		System.out.println("Pattern : "+myTString);
		ObjectXML theObject2 = new ObjectXML();
		theObject2.setTag("France");
		theObject2.setElement("Rhone");
		theObject2.setKey("Lyon");
		String myXMLString2 = (String) lazyConvert.get( theObject2 );
		System.out.println( "Example 1 : " + myXMLString2 );
	}
}




