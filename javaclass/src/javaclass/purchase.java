package javaclass;

public class purchase {
	int shoe=2;
	String brandname="bata";
	
	
	public String purchaseShoeAndGiveToMe() {
		System.out.println("friend i purchase shoes"+shoe+brandname+"and send to you");
		return "vkc";
	}

	public static void main(String[] args) {
		purchase shoes=new purchase();
		String shoe=shoes.purchaseShoeAndGiveToMe();
		System.out.println("i received shoes"+shoe);
		

	}

}
