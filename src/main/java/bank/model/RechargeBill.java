package bank.model;

import java.util.Date;

public class RechargeBill {
	private int txnId;
	private Date txnDate;
	private int txnAmt;
	private int txnAccNo;
	private String txnMobNo;
	private String txnServiceProvider;
	public RechargeBill() {
		super();
	}
	public RechargeBill(int txnId, Date txnDate, int txnAmt, int txnAccNo, String txnMobNo, String txnServiceProvider) {
		super();
		this.txnId = txnId;
		this.txnDate = txnDate;
		this.txnAmt = txnAmt;
		this.txnAccNo = txnAccNo;
		this.txnMobNo = txnMobNo;
		this.txnServiceProvider = txnServiceProvider;
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
	public int getTxnAmt() {
		return txnAmt;
	}
	public void setTxnAmt(int txnAmt) {
		this.txnAmt = txnAmt;
	}
	public int getTxnAccNo() {
		return txnAccNo;
	}
	public void setTxnAccNo(int txnAccNo) {
		this.txnAccNo = txnAccNo;
	}
	public String getTxnMobNo() {
		return txnMobNo;
	}
	public void setTxnMobNo(String txnMobNo) {
		this.txnMobNo = txnMobNo;
	}
	public String getTxnServiceProvider() {
		return txnServiceProvider;
	}
	public void setTxnServiceProvider(String txnServiceProvider) {
		this.txnServiceProvider = txnServiceProvider;
	}
	
	
}
