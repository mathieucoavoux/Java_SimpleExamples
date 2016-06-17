package invokersample;

import java.lang.reflect.Method;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;

import objecttransformer.Payment;

public class InvokerHandler {
	public static void basicInvoke() {
		Class myClass = Payment.class;
		try {
			Object myNObject = myClass.newInstance();
			Method myMethod = myClass.getMethod("getIdPayment");
			Object output = myMethod.invoke(myNObject);
			System.out.println("id payment : "+output.toString());
			
			
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	public static void advancedInvoke() {
		try {
			Class[] myArrClass = new Class[] { Payment.class };
			Object myNObject2 = myArrClass[0].newInstance();
			Object[] myArrObject = new Object[] { myNObject2 };
			//Transformer trInvo = InvokerTransformer.getInstance("getIdPayment",new Class[0] , new Object[0]);
			//Transformer myTransfo = TransformerUtils.invokerTransformer("toString",myArrClass,myArrObject);
			Transformer myTransfo = TransformerUtils.invokerTransformer("getBank",new Class[0] , new Object[0]);
			Object myTranObj = myTransfo.transform(myNObject2);
			System.out.println("Invoker : ");
			System.out.println("bank name :"+myTranObj.toString());
			//displayObjectProperties(myTranObj);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) {
		basicInvoke();
		advancedInvoke();
	}
}
