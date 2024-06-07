package bank.dao;

import java.util.List;

import bank.model.Register;

public interface BankDao {
	public int registerUser(List<Register> rList);
	public List<Register> validateUser(String uname,String Password);
	public boolean validateBalance(int amt,int accNo);
	public int updateBalance(float newBal,int accNo);
	public int updatePassword(String uName,String oldPass,String newPass);
}
