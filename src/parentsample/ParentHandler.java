package parentsample;

public class ParentHandler {

	public static void main(String args[]) {
		MyChild mathieu = new MyChild();
		System.out.println("get id");
		System.out.println("Son id  :"+mathieu.getChildId());
		
		MyDad frederic = new MyDad();
		System.out.println("get dad name :"+frederic.Name);
	}
}
