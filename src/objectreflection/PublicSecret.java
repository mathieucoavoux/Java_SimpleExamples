package objectreflection;

class PublicSecret {
	public String publicSecret = "The president is dead";
	public String privateSecret = "He has been killed by his wife";
	
	public String getPublicSecret() {
		return publicSecret;
	}
	public String getPrivateSecret() {
		return privateSecret;
	}
	
	private PublicSecret() {
	//PublicSecret() {
		System.out.println("Private secret in the constructor");
	}
}
