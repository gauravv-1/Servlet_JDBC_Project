package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bank.model.Register;

public class BankDaoImpl implements BankDao {
	Connection con=null;
	PreparedStatement pstate=null;
	ResultSet result = null;

	@Override
	public int registerUser(List<Register> rList) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		Register r = rList.get(0);
		int i=0;
		
		try {
			pstate=con.prepareStatement("insert into bankRegistration values (?,?,?,?,?,?)");
			pstate.setString(1, r.getfName());
			pstate.setString(2, r.getlName());
			pstate.setString(3, r.getUname());
			pstate.setString(4, r.getPassword());
			pstate.setInt(5, r.getAccNo());
			pstate.setFloat(6, r.getAccBal());
			
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}


	@Override
	public List<Register> validateUser(String uname, String Password) {
		// TODO Auto-generated method stub
		
		con=DBConnection.myConnection();
		List<Register> rList = new ArrayList<Register>();
		
		try {
			pstate=con.prepareStatement("select * from bankRegistration where u_name=? and password=?");
			pstate.setString(1, uname);
			pstate.setString(2, Password);
			
			result=pstate.executeQuery();
			
			if(result.next()) {
				
				Register r = new Register(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getFloat(6));
				rList.add(r);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rList;
	}


	@Override
	public boolean validateBalance(int amt,int accNo) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		float accBal=0;
		boolean sufficientBal=false;
		try {
			pstate=con.prepareStatement("select * from bankRegistration where acc_no=?");
			pstate.setInt(1, accNo);
			result=pstate.executeQuery();
			
			if(result.next()) {
				accBal=result.getFloat(6);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(accBal>amt) {
			sufficientBal=true;
		}
		
		
		
		return sufficientBal;
	}


	@Override
	public int updateBalance(float newBal, int accNo) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		int i=0;
		
		try {
			pstate=con.prepareStatement("update bankRegistration set acc_bal=? where acc_no=?");
			pstate.setFloat(1, newBal);
			pstate.setInt(2, accNo);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	

	@Override
	public int updatePassword(String uName, String oldPass, String newPass) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		boolean flag=false;
		int i=0;
		try {
			pstate=con.prepareStatement("select * from bankRegistration where u_name=? and password=?");
			pstate.setString(1, uName);
			pstate.setString(2, oldPass);
			result=pstate.executeQuery();
			if(result.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(flag) {
				pstate=con.prepareStatement("update bankRegistration set password=? where u_name=?");
				pstate.setString(1, newPass);
				pstate.setString(2, uName);
				i=pstate.executeUpdate();
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	

}
