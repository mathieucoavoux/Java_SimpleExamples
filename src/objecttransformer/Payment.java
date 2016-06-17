package objecttransformer;

public class Payment {

	public int IdPayment;
	public String Bank;
	public int getIdPayment() {
		return IdPayment;
	}
	public void setIdPayment(int Id) {
		IdPayment = Id;
	}
	public String getBank() {
		return "ANZ";
	}
	public void setBank(String myBank) {
		Bank = myBank;
	}
	public Payment() {
		setIdPayment(1);
	}
}
