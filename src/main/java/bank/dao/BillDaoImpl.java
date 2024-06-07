package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bank.model.RechargeBill;
import bank.model.Register;

import java.sql.Date;

public class BillDaoImpl implements BillDao {
	Connection con=null;
	PreparedStatement pstate=null;
	ResultSet result=null;


	@Override
	public int createRechargeTransaction(RechargeBill rechBill) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		int i=0;
		try {
			pstate = con.prepareStatement("insert into rechargeTransactions (txnId, txnDate, txnAmt, txnAccNo, txnMobNo, txnServiceProvider) values (txn_id.nextval, ?, ?, ?, ?, ?)");

			
			java.sql.Date sqlDate = new java.sql.Date(rechBill.getTxnDate().getTime());
			pstate.setDate(1, sqlDate);
			pstate.setInt(2, rechBill.getTxnAmt());
			pstate.setInt(3, rechBill.getTxnAccNo());
			pstate.setString(4, rechBill.getTxnMobNo());
			pstate.setString(5, rechBill.getTxnServiceProvider());

			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}


	@Override
	public List<RechargeBill> retriveRechargeTransactions(int accNo) {
		List<RechargeBill> rechTxn = new ArrayList<>();
		con = DBConnection.myConnection();

		try {
			pstate = con.prepareStatement("SELECT * FROM rechargeTransactions WHERE TXNACCNO = ? order by txnid desc");
			pstate.setInt(1, accNo);
			result = pstate.executeQuery();

			while (result.next()) {
				// Create a new RechargeBill object for each row and add it to the list
				RechargeBill rBill = new RechargeBill(result.getInt(1), result.getDate(2),
						result.getInt(3), result.getInt(4), result.getString(5), result.getString(6));
				rechTxn.add(rBill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rechTxn;
	}
}
