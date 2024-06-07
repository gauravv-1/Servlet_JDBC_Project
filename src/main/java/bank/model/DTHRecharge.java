package bank.model;

public class DTHRecharge {
	private String consumerNo;
	private String operator;
	private int amt;
	public DTHRecharge(String consumerNo, String operator, int amt) {
		super();
		this.consumerNo = consumerNo;
		this.operator = operator;
		this.amt = amt;
	}
	public String getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	
	
}
