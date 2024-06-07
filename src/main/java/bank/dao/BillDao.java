package bank.dao;

import java.util.List;

import bank.model.RechargeBill;

public interface BillDao {
	public int createRechargeTransaction(RechargeBill rechBill);
	public List<RechargeBill> retriveRechargeTransactions(int accNo);

}
