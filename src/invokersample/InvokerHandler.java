package invokersample;

import java.lang.reflect.Method;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;

import objecttransformer.Payment;

public class InvokerHandler {
	public static void invokeNoArgs() {
		Class myClass = Payment.class;
		try {
			System.out.println("Invoker Transformer without args");
			Object myNObject = myClass.newInstance();
			Method myMethod = myClass.getMethod("getIdPayment");
			Object output = myMethod.invoke(myNObject);
			System.out.println("id payment : "+output.toString());
			
			
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	public static void invokeEmptyArgs() {
		try {
			Class[] myArrClass = new Class[] { Payment.class };
			Object myNObject2 = myArrClass[0].newInstance();
			Object[] myArrObject = new Object[] { myNObject2 };
			System.out.println("Invoker Transformer with new empty class and empty object");
			Transformer myTransfo = TransformerUtils.invokerTransformer("getBank",new Class[0] , new Object[0]);
			Object myTranObj = myTransfo.transform(myNObject2);
			System.out.println("bank name :"+myTranObj.toString());
		}catch(Exception e){
			System.out.println(e);
		}
			
	}
	
	public static void invokeWithArgs() {
		Class[] paramClasses = new Class[] { java.lang.String.class};
		Object[] argObject = new Object[] { "My Answer" };
		try {
			Class[] myArrClass3 = new Class[] { Account.class };
			Object myNObject3 = myArrClass3[0].newInstance();
			System.out.println("Invoker Transformer with String args");
			Transformer myTransfo3 = TransformerUtils.invokerTransformer("getAccountId",paramClasses, argObject);
			Object myTranObj3 = myTransfo3.transform(myNObject3);
			System.out.println("Account Id :"+myTranObj3.toString());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String args[]) {
		invokeNoArgs();
		invokeEmptyArgs();
		invokeWithArgs();
	}
}
