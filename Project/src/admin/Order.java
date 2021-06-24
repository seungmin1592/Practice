package admin;

public class Order {
	
	private int oidx;
	private int ordercode;
	private int icode;
	private int idx ;
	private String orderdate;
	private int count;
	private int oprice;
	
	
	
	public int getOidx() {
		return oidx;
	}
	public void setOidx(int oidx) {
		this.oidx = oidx;
	}
	public int getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(int ordercode) {
		this.ordercode = ordercode;
	}
	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}


	
	
	public Order(int oidx, int ordercode, int icode, int idx, String orderdate, int count, int oprice) {
		this.oidx = oidx;
		this.ordercode = ordercode;
		this.icode = icode;
		this.idx = idx;
		this.orderdate = orderdate;
		this.count = count;
		this.oprice = oprice;
	}
	
	
	@Override
	public String toString() {
		return "Order [oidx=" + oidx + ", ordercode=" + ordercode + ", icode=" + icode + ", idx=" + idx + ", orderdate="
				+ orderdate + ", count=" + count + ", oprice=" + oprice + "]";
	}


	
	
	
	
	
}
