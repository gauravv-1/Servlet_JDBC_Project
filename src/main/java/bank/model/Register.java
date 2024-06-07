package bank.model;

public class Register {
	private String fName;
	private String lName;
	private String uname;
	private String password;
	private int accNo;
	private float accBal;
	public Register() {
		super();
	}
	public Register(String fName, String lName, String uname, String password, int accNo, float accBal) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.uname = uname;
		this.password = password;
		this.accNo = accNo;
		this.accBal = accBal;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
	
}
