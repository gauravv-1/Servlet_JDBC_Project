package bank.model;

public class Recharge {
	private String mobNo;
	private String serviceProvider;
	private int rechAmt;
	public Recharge() {
		super();
	}
	public Recharge(String mobNo, String serviceProvider, int rechAmt) {
		super();
		this.mobNo = mobNo;
		this.serviceProvider = serviceProvider;
		this.rechAmt = rechAmt;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public int getRechAmt() {
		return rechAmt;
	}
	public void setRechAmt(int rechAmt) {
		this.rechAmt = rechAmt;
	}
	
	
	
}
