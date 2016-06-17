package parentsample;

public class MyDad implements MyParent_Impl {
	
	int Id = 2;
	String Name = "Fred";
	int SerialId;
	
	MyDad() {
		//super();
		System.out.println("super class "+super.getClass().toString());
	}
	
	public void help() {
		System.out.println("Help overrided");
	}
	public int getSerialId() {
		return Id++;
	}
	
	public void setSerialId(int mySerialId) {
		SerialId = mySerialId++;
	}

}
