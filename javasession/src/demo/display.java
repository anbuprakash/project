package demo;

	public class display{

		private String com_name;
		private int num;

		public String getcom_name(){
		return com_name;
		}
		 public void setcom_name(String name){
		this.com_name=name;
		}

		public int getnum(){
		return num;
		}
		 public void setnum(int num){
		this.num=num;
		}

		public  static void main(String[] args){
		 display dis=new display();
		dis.setcom_name("accelerated development machines");
		dis.setnum(123);
		System.out.println(dis.getcom_name()+" "+dis.getnum());
		}
		}

