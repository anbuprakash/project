package demo;

public class exencaps {
	int acc_no;
	String name;
	int amount;
	public int getacc_no() {
		return acc_no;
	}
	public void setacc_no(int acc_no) {
		this.acc_no=acc_no;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public int getamount() {
		return amount;
	}
	public void setamount(int amount) {
		this.amount=amount;
	}

	public static void main(String[] args) {
		exencaps en=new exencaps();
		en.setacc_no(2312235);
		en.setname("prakash");
		en.setamount(5000);
		System.out.println(en.getacc_no()+" "+en.getname()+" "+en.getamount());
		

	}

}
