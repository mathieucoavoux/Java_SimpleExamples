package parentsample;

public class MyParent implements MyParent_Impl{
	
	int Id = 1;
	String Name = "Parents";
	int SerialId;
	
	MyParent(){
		help();
	}
	
	public void help() {
		System.out.println("Help is displayed each time class is loaded");
	}
	
	public int getSerialId() {
		return SerialId;
	}
	
	public void setSerialId(int mySerialId) {
		SerialId = mySerialId;
	}
}
