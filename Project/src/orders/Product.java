package orders;

public class Product {
	private int icode;
	private int count;
	private String iname;
	private int iprice;

	
	public Product() {}
	
	public Product(int icode, int count, String iname, int iprice) {
		this.icode = icode;
		this.count = count;
		this.iname = iname;
		this.iprice = iprice;
	}




	public Product(int icode,  int count) {
		this.icode = icode;
		this.count = count;
	}




	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Menu [icode=" + icode + ", iname=" + iname + ", iprice=" + iprice + "]";
	}

}