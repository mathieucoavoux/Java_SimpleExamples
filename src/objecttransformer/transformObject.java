package objecttransformer;

//Use to transform object
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;

//Use to display fields in the current class
import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;

class transformObject {
	public static void main(String args[]) {
		//Create a new Transaction object
		Transaction myTransaction = new Transaction();
		
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
		//Get All Fields stored into object
		Field[] fTrChDObject = FieldUtils.getAllFields(result.getClass());
		//Foreach fields...
		for(int indTrChDObject = 0;indTrChDObject < fTrChDObject.length;indTrChDObject++) {
			//Print the name of the field
			System.out.println("Name of field["+indTrChDObject+"] :"+fTrChDObject[indTrChDObject].toString());
			//Store the current field into a Field variable
			Field oneField = fTrChDObject[indTrChDObject];
			//This is mandatory
			try {
				//Store the value of current field into an object
				Object value = oneField.get(result);
				//Print object value
				System.out.println("Field "+fTrChDObject[indTrChDObject].toString()+" value :"+value.toString());
			}catch(Exception e) {
				//Print exceptions if any occured
				System.out.println(e);
			}
		}
	}
}
