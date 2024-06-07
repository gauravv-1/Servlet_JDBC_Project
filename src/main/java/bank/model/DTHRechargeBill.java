package bank.model;

import java.sql.Date;

public class DTHRechargeBill {
	private int txnId;
	private Date txnDate;
	private int accNo;
	private String consumerNo;
	private String operator;
	private int amt;
	public DTHRechargeBill(int txnId, Date txnDate, int accNo, String consumerNo, String operator, int amt) {
		super();
		this.txnId = txnId;
		this.txnDate = txnDate;
		this.accNo = accNo;
		this.consumerNo = consumerNo;
		this.operator = operator;
		this.amt = amt;
	}
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
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