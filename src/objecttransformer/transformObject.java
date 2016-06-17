package objecttransformer;

//Use to transform object
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import java.lang.reflect.Method;

import java.lang.reflect.InvocationHandler;

//Use to display fields in the current class
import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;

class transformObject {
	public static Object chainTransformation(Transaction myTransaction) {
		//Define a new Transaction object
		//This object is getting the hashCode of the input object to store it into a HashTransaction object
		Transformer tranObject = new Transformer() {
			//The transform function is mandatory. Read the Javadoc for further informations
			public Object transform(Object input) {
				//Create new Hash transaction object
				HashTransaction myHashObject = new HashTransaction();
				//Store the Object hashCode into a variable
				int myHashCode = input.hashCode();
				//Set the HashTransaction id to 1
				myHashObject.setId(1);
				//Set the HashTransaction Hashcode to the value of the variable
				myHashObject.setHashcode(myHashCode);
				//Return the HashTransaction Object
				return myHashObject;
			}
		};
		//This is creating a new Transformer array with a single Transformer object
		Transformer[] chainSingleElement = new Transformer[] { tranObject };
		//Creating a Transformer chain based on array created before
		Transformer chain = new ChainedTransformer( chainSingleElement );
		//Transform myTransaction and store result into an object
		Object result = chain.transform(myTransaction);
		return result;
	}
	
	public static Object chainTransformation2(Transaction myTransaction,Transformer tranObject) {
		//Create a new Transformer which increment the Hascode by 1
				Transformer incrObject = new Transformer() {
					public Object transform(Object input) {
						//Get the hashcode field;
						try {
							//Get the Hashcode field
							Field fieldHash = input.getClass().getDeclaredField("Hashcode");
							//Get the Hashcode value
							Object vObjectHash = fieldHash.get(input);
							//Cast to integer
							int myIncHash = Integer.parseInt(vObjectHash.toString());
							//Increment by 1
							myIncHash++;
							//Create a new HashTransaction object
							HashTransaction twoHash = new HashTransaction();
							//Set the id
							twoHash.setId(2);
							//Set the new hashcode
							twoHash.setHashcode(myIncHash);
							return twoHash;
						}catch(Exception e){
							return (new Integer(1));
						}
					}
				};
				//Create a second chain with 2 elements
				Transformer[] chainTwoElements = new Transformer[] { tranObject,incrObject };
				//Creating a Transformer chain based on array created before
				Transformer chain2 = new ChainedTransformer( chainTwoElements );
				//Transform myTransaction and store result into an object
				Object result2 = chain2.transform(myTransaction);
				return result2;
	}
	
	public static Object constantTransformation(Object myTransaction) {
		//ConstantTransformer myCT = new ConstantTransformer(1);
		ConstantTransformer myCT = new ConstantTransformer(myTransaction);
		
		return myCT.getConstant();
		//return ConstantTransformer.getInstance(myTransaction);
	}
	
	public static void constantTransfoCustom() {
		ConTransfo myCon = new ConTransfo(1);
		System.out.println("constantTransfoCustom");
		displayObjectProperties(myCon);
		ConTransfo myCon2 = new ConTransfo(Runtime.class);
		System.out.println("constantTransfoCustom 2 :");
		displayObjectProperties(myCon2);
		//System.out.println("con custom :"+myCon.iConstant.toString());
	}
	
	public static void displayObjectProperties(Object result2) {
		
		//Get All Fields stored into object
		Field[] fTrCh2Object = FieldUtils.getAllFields(result2.getClass());
		//Foreach fields...
		for(int indTrCh2Object = 0;indTrCh2Object < fTrCh2Object.length;indTrCh2Object++) {
			//Print the name of the field
			System.out.println("Name of field["+indTrCh2Object+"] :"+fTrCh2Object[indTrCh2Object].toString());
			//Store the current field into a Field variable
			Field twoField = fTrCh2Object[indTrCh2Object];
			//This is mandatory
			try {
				//Store the value of current field into an object
				Object value2 = twoField.get(result2);
				//Print object value
				System.out.println("Field "+fTrCh2Object[indTrCh2Object].toString()+" value :"+value2.toString());
			}catch(Exception e) {
				//Print exceptions if any occured
				System.out.println(e);
			}
		}
	}
	
	public static void main(String args[]) {
		//Create a new Transaction object
		Transaction myTransaction = new Transaction();
		myTransaction.setId(1);
		Object myNewTrans = constantTransformation(myTransaction);
		
		displayObjectProperties(myNewTrans);
		
		System.out.println("**********************");
		System.out.println("Single Chained element :");
		Object result = chainTransformation(myTransaction);
		//Get All Fields stored into object
		displayObjectProperties(result);
		
		System.out.println("**********************");
		System.out.println("\n");
		System.out.println("**********************");
		System.out.println("Two Chained elements :");
		
		
		System.out.println("**********************");
		constantTransfoCustom();
		
	}
}
