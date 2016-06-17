package parentsample;

public class MyChild extends MyParent {
	
	int ChildId = 1;
	public int getChildId() {
		return ChildId;
	}
	public void setChildId(int myChildId) {
		ChildId = myChildId;
	}
	
	public MyChild() {
		super();
		System.out.println("Remind me my parent");
		System.out.println("What was his name :"+Name);
	}
}
